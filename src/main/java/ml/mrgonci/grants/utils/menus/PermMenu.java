package ml.mrgonci.grants.utils.menus;

import com.cryptomorin.xseries.XMaterial;
import ml.mrgonci.grants.utils.interfaces.Grant;
import ml.mrgonci.grants.utils.interfaces.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Optional;

public final class PermMenu implements InventoryHolder, Grant {

    private final Inventory inv = Bukkit.createInventory(PermMenu.this, getSettings.getInt("Menu.rows") * 9, StringUtils.toColor(getSettings.getString("Menu.title", "&cGrants &8| &bRanks")));

    private void init(){
        for (String rank : Objects.requireNonNull(getSettings.getConfigurationSection("Ranks")).getKeys(false)){

            String name = StringUtils.toColor(getSettings.getString("Ranks." + rank + ".name"));
            String material_name = getSettings.getString("Ranks." + rank + ".material");
            Optional<XMaterial> material = XMaterial.matchXMaterial(material_name);

            if(material.isPresent()) {
                ItemStack item = createItem(name, material.get().parseMaterial());
                inv.setItem(getSettings.getInt("Ranks." + rank + ".slot"), item);
            }else{
                inv.setItem(getSettings.getInt("Ranks." + rank + ".slot"), new ItemStack(Material.STONE));
            }
        }
    }

    private ItemStack createItem(String name, Material mat){
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        assert meta != null;
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public final @NotNull Inventory getInventory() {
        init();
        return inv;
    }
}
