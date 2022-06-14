package com.alli.gamebreaker;

import net.minecraft.text.Text;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.tooltip.api.client.ItemTooltipCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBreakerClient implements ClientModInitializer {
	private final Random rand = new Random();

	@Override
	public void onInitializeClient(ModContainer mod) {
		ItemTooltipCallback.EVENT.register((stack, player, context, list) -> {
			List<Text> list2 = new ArrayList<>();
			List<Integer> order = new ArrayList<>();

			for (int i = 0; i < 5; i++) {
				String line = "";
				int letter = 0;
				for (int g = 0; g < 20; g++) {
					int chance = rand.nextInt(2);
					if (chance == 0) {
						letter = 65 + rand.nextInt(26);
					} else {
						letter = 97 + rand.nextInt(26);
					}
					line += (char) letter;
				}
				list.add(Text.of(line));
			}

			for (int i = 0; i < list.size() - 1; i++) {
				int addition = rand.nextInt(list.size());
				if (!order.contains(addition) && addition != 0) {
					order.add(addition);
				} else {
					i--;
				}
			}

			list2.add(list.get(0));
			for (int i = 0; i < list.size() - 1; i++) {
				list2.add(list.get(order.get(i)));
			}
			list.clear();
			list.addAll(list2);
		});
	}
}
