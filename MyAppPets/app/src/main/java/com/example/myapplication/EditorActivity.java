/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.myapplication;

import android.os.Bundle;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

/**
 * Позволяет пользователю создать нового питомца или отредактировать существующего.
 */
public class EditorActivity extends AppCompatActivity {

    /** Поле EditText для ввода имени питомца  */
    private EditText mNameEditText;

    /** Поле EditText для ввода породы питомца  */
    private EditText mBreedEditText;

    /** Поле EditText для ввода веса питомца */
    private EditText mWeightEditText;

    /** Поле EditText для ввода пола питомца */
    private Spinner mGenderSpinner;

    /**
     * Пол питомца. Возможные значения:
     * 0 - пол неизвестен, 1 - мужской, 2 - женский.
     */
    private int mGender = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Находим все соответствующие представления,
        // которые нам понадобятся для чтения пользовательского ввода
        mNameEditText = (EditText) findViewById(R.id.edit_pet_name);
        mBreedEditText = (EditText) findViewById(R.id.edit_pet_breed);
        mWeightEditText = (EditText) findViewById(R.id.edit_pet_weight);
        mGenderSpinner = (Spinner) findViewById(R.id.spinner_gender);

        setupSpinner();
    }

    /**
     * Настройте выпадающий счетчик, который позволяет пользователю выбрать пол питомца.
     */
    private void setupSpinner() {
        // Создаем адаптер для счетчика. Параметры списка взяты из массива String, который он будет использовать
        // счетчик будет использовать макет по умолчанию
        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_gender_options, android.R.layout.simple_spinner_item);

        // Укажите стиль макета раскрывающегося списка - простой вид списка с 1 элементом в строке
        genderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Применяем адаптер к спиннеру
        mGenderSpinner.setAdapter(genderSpinnerAdapter);

        // Устанавливаем целое число mSelected на постоянные значения
        mGenderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.gender_male))) {
                        mGender = 1; // Male
                    } else if (selection.equals(getString(R.string.gender_female))) {
                        mGender = 2; // Female
                    } else {
                        mGender = 0; // Unknown
                    }
                }
            }

            // Поскольку AdapterView является абстрактным классом,
            // необходимо определить onNothingSelected
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 0; // Unknown
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Расширение параметров меню из файла res / menu / menu_editor.xml.
        // Это добавляет пункты меню на панель приложения.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Пользователь щелкнул пункт меню в меню переполнения панели приложения
        switch (item.getItemId()) {
            // Отвечаем на щелчок по опции меню "Сохранить"
            case R.id.action_save:
                // Пока ничего не делаем
                return true;
            //Отвечаем на щелчок по опции меню "Удалить"
            case R.id.action_delete:
                // Пока ничего не делаем
                return true;
            // Отвечаем на нажатие кнопки со стрелкой «Вверх» на панели приложения
            case android.R.id.home:
                // Возвращаемся к родительскому действию (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}