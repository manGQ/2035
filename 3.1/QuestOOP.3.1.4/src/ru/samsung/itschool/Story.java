package ru.samsung.itschool;

import java.util.Scanner;

public class Story {

	private Situation start_story;
	public Situation current_situation;

	Story() {
		start_story = new Situation(
				"первая сделка (Windows)",
				"Только вы начали работать и тут-же удача! Вы нашли клиента и продаете ему "
						+ "партию ПО МС Виндовс. Ему в принципе достаточно взять 100 коробок версии HOME.\n"
						+ "(1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр\n"
						+ "(2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр\n"
						+ "(3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр ",
				3, 0, 0, 0);
		start_story.direction[0] = new Situation(
				"корпоратив",
				"Неудачное начало, ну чтож, сегодня в конторе копроратив! "
						+ "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу",
				0, 0, -10, -10);
		start_story.direction[1] = new Situation(
				"совещание, босс доволен",
				"Сегодня будет совещание, меня неожиданно вызвали,"
						+ "есть сведения что \n босс доволен сегодняшней сделкой.",
				0, 1, 100, 0);
		start_story.direction[2] = new Situation(
				"мой первый лояльный клиент",
				"Мой первый клиент доворлен скоростью и качеством "
						+ "моей работы. Сейчас мне звонил лично \nдиреткор компании и сообщил что скоро состоится еще более крупная сделка"
						+ " и он хотел чтобы по нейт работал именно я!", 0, 0,
				50, 1);
		current_situation = start_story;
	}

	public void go(int num) {
		if (num <= current_situation.direction.length)
			current_situation = current_situation.direction[num - 1];
		else
			System.out.println("Вы можете выьирать из "
					+ current_situation.direction.length + " вариантов");
	}

	public boolean isEnd() {
		return current_situation.direction.length == 0;
	}
}