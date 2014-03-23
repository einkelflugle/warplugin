package com.maxcmiller.war;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import com.maxcmiller.war.enums.Rank;

public class GUI {
	
	private Inventory privateInv, corporalInv, sergeantInv, generalInv;
	private ItemStack medic, location, bombardment;
	
	public GUI() {
		/*
		 * Create all the inventories for each rank
		 */
		privateInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Commands for privates");
		corporalInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Commands for corporals");
		sergeantInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Commands for sergeants");
		generalInv = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Commands for generals");
		
		/*
		 * Create all the items for the GUI commands
		 */
		medic = createPotion(new Potion(PotionType.INSTANT_HEAL), ChatColor.RED, "Request a medic");
		location = createNormalItem(Material.COMPASS, ChatColor.YELLOW + "Check your current location");
		bombardment = createNormalItem(Material.TNT, ChatColor.DARK_RED + "Bombard the enemy's current HQ");
		
		/*
		 * Adds the items to the GUI inventory screen according to the rank
		 */
		privateInv.addItem(medic);
		privateInv.addItem(location);
		
		corporalInv.addItem(medic);
		corporalInv.addItem(location);
		
		sergeantInv.addItem(medic);
		sergeantInv.addItem(location);
		
		generalInv.addItem(medic);
		generalInv.addItem(location);
		generalInv.addItem(bombardment);
	}

	private ItemStack createNormalItem(Material normalItem, String name) {
		ItemStack is = new ItemStack(normalItem);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		is.setItemMeta(im);
		return is;
	}
	
	private ItemStack createPotion(Potion potion, ChatColor color, String name) {
		ItemStack is = potion.toItemStack(1);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(color + name);
		is.setItemMeta(im);
		return is;
	}
	
	public Inventory getInventory(Rank rank) {
		if (rank == Rank.PRIVATE) {
			return privateInv;
		} else if (rank == Rank.CORPORAL) {
			return corporalInv;
		} else if (rank == Rank.PRIVATE) {
			return sergeantInv;
		} else if (rank == Rank.GENERAL) {
			return generalInv;
		}
		return null;
	}
}
