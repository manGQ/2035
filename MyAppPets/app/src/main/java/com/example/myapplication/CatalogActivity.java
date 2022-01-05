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

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/*
** Отображает список домашних животных, которые были введены и сохранены в приложении.
*/
public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);  //создается разметка на экране

        // Настраиваем FAB для открытия EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //находим кнопку на экране
        fab.setOnClickListener(new View.OnClickListener() { //устанавливаем на кнопку прослушиватель кликов
            @Override
            public void onClick(View view) { // при нажатии на кнопку
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);// создается интент чтобы открыть Активити редактора
                startActivity(intent); //запускаем интент
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Расширение пунктов меню из файла res / menu / menu_catalog.xml.
        // Это добавляет пункты меню на панель приложения.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Пользователь щелкнул пункт меню в меню переполнения панели приложения
        switch (item.getItemId()) {
            // Отвечаем на щелчок по пункту меню "Вставить фиктивные данные"
            case R.id.action_insert_dummy_data:
                // Пока ничего не делаем
                return true;
            // Отвечаем на щелчок по пункту меню "Удалить все записи"
            case R.id.action_delete_all_entries:
                // Пока ничего не делаем
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
