package mods.railcraft.world.item;

import java.util.function.Function;
import javax.annotation.Nullable;
import mods.railcraft.Railcraft;
import mods.railcraft.Translations;
import mods.railcraft.util.VariantRegistrar;
import mods.railcraft.world.entity.vehicle.TankMinecart;
import mods.railcraft.world.entity.vehicle.TrackLayer;
import mods.railcraft.world.entity.vehicle.TrackRemover;
import mods.railcraft.world.entity.vehicle.locomotive.CreativeLocomotive;
import mods.railcraft.world.entity.vehicle.locomotive.ElectricLocomotive;
import mods.railcraft.world.entity.vehicle.locomotive.SteamLocomotive;
import mods.railcraft.world.item.crafting.RailcraftRecipeTypes;
import mods.railcraft.world.level.block.RailcraftBlocks;
import mods.railcraft.world.level.block.track.TrackTypes;
import mods.railcraft.world.level.material.fluid.RailcraftFluids;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RailcraftItems {

  private static final DeferredRegister<Item> deferredRegister =
      DeferredRegister.create(ForgeRegistries.ITEMS, Railcraft.ID);

  public static void register(IEventBus modEventBus) {
    deferredRegister.register(modEventBus);
  }

  /**
   * Railcraft's creative tab.
   */
  public static final CreativeModeTab TAB =
      new CreativeModeTab(Translations.Tab.withoutPrefix(Translations.Tab.RAILCRAFT)) {
        @Override
        public ItemStack makeIcon() {
          return new ItemStack(IRON_CROWBAR.get());
        }
      };

  public static final CreativeModeTab OUTFITTED_TRACKS_TAB =
      new CreativeModeTab(Translations.Tab.withoutPrefix(
          Translations.Tab.RAILCRAFT_OUTFITTED_TRACKS)) {
        @Override
        public ItemStack makeIcon() {
          return new ItemStack(IRON_DETECTOR_TRACK.get());
        }
      };

  public static final CreativeModeTab DECORATIVE_TAB =
      new CreativeModeTab(Translations.Tab.withoutPrefix(
          Translations.Tab.RAILCRAFT_DECORATIVE_BLOCKS)) {
        @Override
        public ItemStack makeIcon() {
          return new ItemStack(STRENGTHENED_GLASS.variantFor(DyeColor.BLACK).get());
        }
      };

  public static final VariantRegistrar<DyeColor, BlockItem> STRENGTHENED_GLASS =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> POST =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> IRON_TANK_GAUGE =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> IRON_TANK_VALVE =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> IRON_TANK_WALL =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> STEEL_TANK_GAUGE =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> STEEL_TANK_VALVE =
      VariantRegistrar.from(DyeColor.class, deferredRegister);
  public static final VariantRegistrar<DyeColor, BlockItem> STEEL_TANK_WALL =
      VariantRegistrar.from(DyeColor.class, deferredRegister);

  static {
    var decorativeTabFactory = blockItemFactory(DECORATIVE_TAB);
    STRENGTHENED_GLASS.registerUsing(RailcraftBlocks.STRENGTHENED_GLASS, decorativeTabFactory);
    POST.registerUsing(RailcraftBlocks.POST, decorativeTabFactory);

    var tabFactory = blockItemFactory(TAB);
    IRON_TANK_GAUGE.registerUsing(RailcraftBlocks.IRON_TANK_GAUGE, tabFactory);
    IRON_TANK_VALVE.registerUsing(RailcraftBlocks.IRON_TANK_VALVE, tabFactory);
    IRON_TANK_WALL.registerUsing(RailcraftBlocks.IRON_TANK_WALL, tabFactory);

    STEEL_TANK_GAUGE.registerUsing(RailcraftBlocks.STEEL_TANK_GAUGE, tabFactory);
    STEEL_TANK_VALVE.registerUsing(RailcraftBlocks.STEEL_TANK_VALVE, tabFactory);
    STEEL_TANK_WALL.registerUsing(RailcraftBlocks.STEEL_TANK_WALL, tabFactory);
  }

  public static final RegistryObject<Item> LOW_PRESSURE_STEAM_BOILER_TANK =
      deferredRegister.register("low_pressure_steam_boiler_tank",
          () -> new BlockItem(RailcraftBlocks.LOW_PRESSURE_STEAM_BOILER_TANK.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> HIGH_PRESSURE_STEAM_BOILER_TANK =
      deferredRegister.register("high_pressure_steam_boiler_tank",
          () -> new BlockItem(RailcraftBlocks.HIGH_PRESSURE_STEAM_BOILER_TANK.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SOLID_FUELED_FIREBOX =
      deferredRegister.register("solid_fueled_firebox",
          () -> new BlockItem(RailcraftBlocks.SOLID_FUELED_FIREBOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> FLUID_FUELED_FIREBOX =
      deferredRegister.register("fluid_fueled_firebox",
          () -> new BlockItem(RailcraftBlocks.FLUID_FUELED_FIREBOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_LABEL =
      deferredRegister.register("signal_label",
          () -> new SignalLabelItem(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TURBINE_ROTOR =
      deferredRegister.register("turbine_rotor",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEAM_TURBINE =
      deferredRegister.register("steam_turbine",
          () -> new BlockItem(RailcraftBlocks.STEAM_TURBINE.get(), new Item.Properties().tab(TAB)));


  public static final RegistryObject<Item> BLAST_FURNACE_BRICKS =
      deferredRegister.register("blast_furnace_bricks",
          () -> new BlockItem(RailcraftBlocks.BLAST_FURNACE_BRICKS.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SLAG =
      deferredRegister.register("slag",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> FEED_STATION =
      deferredRegister.register("feed_station",
          () -> new BlockItem(RailcraftBlocks.FEED_STATION.get(), new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_ANVIL =
      deferredRegister.register("steel_anvil",
          () -> new BlockItem(RailcraftBlocks.STEEL_ANVIL.get(), new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> CHIPPED_STEEL_ANVIL =
      deferredRegister.register("chipped_steel_anvil",
          () -> new BlockItem(RailcraftBlocks.CHIPPED_STEEL_ANVIL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DAMAGED_STEEL_ANVIL =
      deferredRegister.register("damaged_steel_anvil",
          () -> new BlockItem(RailcraftBlocks.DAMAGED_STEEL_ANVIL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_BLOCK =
      deferredRegister.register("steel_block",
          () -> new BlockItem(RailcraftBlocks.STEEL_BLOCK.get(), new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_SHEARS =
      deferredRegister.register("steel_shears",
          () -> new ShearsItem(new Item.Properties()
              .durability(500)
              .tab(TAB)));

  public static final RegistryObject<Item> STEEL_SWORD =
      deferredRegister.register("steel_sword",
          () -> new SwordItem(RailcraftItemTier.STEEL, 3, -2.4F,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_SHOVEL =
      deferredRegister.register("steel_shovel",
          () -> new ShovelItem(RailcraftItemTier.STEEL, 1.5F, -3.0F,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_PICKAXE =
      deferredRegister.register("steel_pickaxe",
          () -> new PickaxeItem(RailcraftItemTier.STEEL, 1, -2.8F,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_AXE =
      deferredRegister.register("steel_axe",
          () -> new AxeItem(RailcraftItemTier.STEEL, 8.0F, -3F,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_HOE =
      deferredRegister.register("steel_hoe",
          () -> new HoeItem(RailcraftItemTier.STEEL, -2, -0.5F,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_BOOTS =
      deferredRegister.register("steel_boots",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, EquipmentSlot.FEET,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_CHESTPLATE =
      deferredRegister.register("steel_chestplate",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, EquipmentSlot.CHEST,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_HELMET =
      deferredRegister.register("steel_helmet",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, EquipmentSlot.HEAD,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_LEGGINGS =
      deferredRegister.register("steel_leggings",
          () -> new ArmorItem(RailcraftArmorMaterial.STEEL, EquipmentSlot.LEGS,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> IRON_TUNNEL_BORE_HEAD =
      deferredRegister.register("iron_tunnel_bore_head",
          () -> new IronTunnelBoreHeadItem(new Item.Properties()
              .tab(TAB)
              .durability(1500)));

  public static final RegistryObject<Item> BRONZE_TUNNEL_BORE_HEAD =
      deferredRegister.register("bronze_tunnel_bore_head",
          () -> new BronzeTunnelBoreHeadItem(new Item.Properties()
              .tab(TAB)
              .durability(1200)));

  public static final RegistryObject<Item> STEEL_TUNNEL_BORE_HEAD =
      deferredRegister.register("steel_tunnel_bore_head",
          () -> new SteelTunnelBoreHeadItem(
              new Item.Properties()
                  .tab(TAB)
                  .durability(3000)));

  public static final RegistryObject<Item> DIAMOND_TUNNEL_BORE_HEAD =
      deferredRegister.register("diamond_tunnel_bore_head",
          () -> new DiamondTunnelBoreHeadItem(new Item.Properties()
              .tab(TAB)
              .durability(6000)));

  public static final RegistryObject<Item> TANK_MINECART =
      deferredRegister.register("tank_minecart",
          () -> new CartItem(TankMinecart::new,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> FLUID_LOADER =
      deferredRegister.register("fluid_loader",
          () -> new BlockItem(RailcraftBlocks.FLUID_LOADER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> FLUID_UNLOADER =
      deferredRegister.register("fluid_unloader",
          () -> new BlockItem(RailcraftBlocks.FLUID_UNLOADER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ADVANCED_ITEM_LOADER =
      deferredRegister.register("advanced_item_loader",
          () -> new BlockItem(RailcraftBlocks.ADVANCED_ITEM_LOADER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ADVANCED_ITEM_UNLOADER =
      deferredRegister.register("advanced_item_unloader",
          () -> new BlockItem(RailcraftBlocks.ADVANCED_ITEM_UNLOADER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ITEM_LOADER =
      deferredRegister.register("item_loader",
          () -> new BlockItem(RailcraftBlocks.ITEM_LOADER.get(), new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ITEM_UNLOADER =
      deferredRegister.register("item_unloader",
          () -> new BlockItem(RailcraftBlocks.ITEM_UNLOADER.get(), new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> IRON_SPIKE_MAUL =
      deferredRegister.register("iron_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.5F, Tiers.IRON,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_SPIKE_MAUL =
      deferredRegister.register("steel_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.4F, RailcraftItemTier.STEEL,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DIAMOND_SPIKE_MAUL =
      deferredRegister.register("diamond_spike_maul",
          () -> new SpikeMaulItem(11.0F, -3.3F, Tiers.DIAMOND,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SWITCH_TRACK_LEVER =
      deferredRegister.register("switch_track_lever",
          () -> new BlockItem(RailcraftBlocks.SWITCH_TRACK_LEVER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SWITCH_TRACK_MOTOR =
      deferredRegister.register("switch_track_motor",
          () -> new BlockItem(RailcraftBlocks.SWITCH_TRACK_MOTOR.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_TUNER =
      deferredRegister.register("signal_tuner",
          () -> new SignalTunerItem(
              new Item.Properties()
                  .stacksTo(1)
                  .tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_BLOCK_SURVEYOR =
      deferredRegister.register("signal_block_surveyor",
          () -> new SignalBlockSurveyorItem(new Item.Properties()
              .stacksTo(1)
              .tab(TAB)));

  public static final RegistryObject<Item> ANALOG_SIGNAL_CONTROLLER_BOX =
      deferredRegister.register("analog_signal_controller_box",
          () -> new BlockItem(
              RailcraftBlocks.ANALOG_SIGNAL_CONTROLLER_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_SEQUENCER_BOX =
      deferredRegister.register("signal_sequencer_box",
          () -> new BlockItem(
              RailcraftBlocks.SIGNAL_SEQUENCER_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_CAPACITOR_BOX =
      deferredRegister.register("signal_capacitor_box",
          () -> new BlockItem(
              RailcraftBlocks.SIGNAL_CAPACITOR_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_INTERLOCK_BOX =
      deferredRegister.register("signal_interlock_box",
          () -> new BlockItem(
              RailcraftBlocks.SIGNAL_INTERLOCK_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BLOCK_SIGNAL_RELAY_BOX =
      deferredRegister.register("block_signal_relay_box",
          () -> new BlockItem(
              RailcraftBlocks.BLOCK_SIGNAL_RELAY_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_RECEIVER_BOX =
      deferredRegister.register("signal_receiver_box",
          () -> new BlockItem(
              RailcraftBlocks.SIGNAL_RECEIVER_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_CONTROLLER_BOX =
      deferredRegister.register("signal_controller_box",
          () -> new BlockItem(
              RailcraftBlocks.SIGNAL_CONTROLLER_BOX.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DUAL_BLOCK_SIGNAL =
      deferredRegister.register("dual_block_signal",
          () -> new BlockItem(
              RailcraftBlocks.DUAL_BLOCK_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DUAL_DISTANT_SIGNAL =
      deferredRegister.register("dual_distant_signal",
          () -> new BlockItem(
              RailcraftBlocks.DUAL_DISTANT_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DUAL_TOKEN_SIGNAL =
      deferredRegister.register("dual_token_signal",
          () -> new BlockItem(
              RailcraftBlocks.DUAL_TOKEN_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BLOCK_SIGNAL =
      deferredRegister.register("block_signal",
          () -> new BlockItem(
              RailcraftBlocks.BLOCK_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DISTANT_SIGNAL =
      deferredRegister.register("distant_signal",
          () -> new BlockItem(
              RailcraftBlocks.DISTANT_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TOKEN_SIGNAL =
      deferredRegister.register("token_signal",
          () -> new BlockItem(
              RailcraftBlocks.TOKEN_SIGNAL.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TRACK_REMOVER =
      deferredRegister.register("track_remover",
          () -> new CartItem(TrackRemover::new,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TRACK_LAYER =
      deferredRegister.register("track_layer",
          () -> new CartItem(TrackLayer::new,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TUNNEL_BORE =
      deferredRegister.register("tunnel_bore",
          () -> new TunnelBoreItem(new Item.Properties()
              .stacksTo(1)
              .tab(TAB)));

  public static final RegistryObject<Item> CREATIVE_LOCOMOTIVE =
      deferredRegister.register("creative_locomotive",
          () -> new LocomotiveItem(CreativeLocomotive::new,
              DyeColor.BLACK, DyeColor.MAGENTA,
              new Item.Properties()
                  .stacksTo(1)
                  .tab(TAB)));

  public static final RegistryObject<Item> ELECTRIC_LOCOMOTIVE =
      deferredRegister.register("electric_locomotive",
          () -> new LocomotiveItem(ElectricLocomotive::new,
              DyeColor.YELLOW, DyeColor.BLACK,
              new Item.Properties()
                  .stacksTo(1)
                  .tab(TAB)));

  public static final RegistryObject<Item> STEAM_LOCOMOTIVE =
      deferredRegister.register("steam_locomotive",
          () -> new LocomotiveItem(SteamLocomotive::new,
              DyeColor.LIGHT_GRAY, DyeColor.GRAY,
              new Item.Properties()
                  .stacksTo(1)
                  .tab(TAB)));

  public static final RegistryObject<Item> WHISTLE_TUNER =
      deferredRegister.register("whistle_tuner",
          () -> new Item(new Item.Properties().durability(250).tab(TAB)));

  public static final RegistryObject<Item> TICKET =
      deferredRegister.register("ticket",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> OVERALLS =
      deferredRegister.register("overalls",
          () -> new ArmorItem(RailcraftArmorMaterial.OVERALLS, EquipmentSlot.LEGS,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> CRACKED_FIRESTONE =
      deferredRegister.register("cracked_firestone",
          () -> new CrackedFirestoneItem(new Item.Properties()
              .stacksTo(1)
              .durability(RefinedFirestoneItem.CHARGES)
              .tab(TAB)));

  public static final RegistryObject<Item> RAW_FIRESTONE =
      deferredRegister.register("raw_firestone", () -> new FirestoneItem(
          new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> CUT_FIRESTONE =
      deferredRegister.register("cut_firestone", () -> new FirestoneItem(
          new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> REFINED_FIRESTONE =
      deferredRegister.register("refined_firestone",
          () -> new RefinedFirestoneItem(new Item.Properties()
              .stacksTo(1)
              .durability(RefinedFirestoneItem.CHARGES)
              .tab(TAB)));

  public static final RegistryObject<BlockItem> FORCE_TRACK_EMITTER =
      deferredRegister.register("force_track_emitter",
          () -> new BlockItem(
              RailcraftBlocks.FORCE_TRACK_EMITTER.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ABANDONED_TRACK =
      deferredRegister.register("abandoned_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> ABANDONED_LOCKING_TRACK =
      deferredRegister.register("abandoned_locking_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_BUFFER_STOP_TRACK =
      deferredRegister.register("abandoned_buffer_stop_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_BUFFER_STOP_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_ACTIVATOR_TRACK =
      deferredRegister.register("abandoned_activator_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_BOOSTER_TRACK =
      deferredRegister.register("abandoned_booster_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_CONTROL_TRACK =
      deferredRegister.register("abandoned_control_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_CONTROL_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_GATED_TRACK =
      deferredRegister.register("abandoned_gated_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_GATED_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_DETECTOR_TRACK =
      deferredRegister.register("abandoned_detector_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_COUPLER_TRACK =
      deferredRegister.register("abandoned_coupler_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_COUPLER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_EMBARKING_TRACK =
      deferredRegister.register("abandoned_embarking_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_EMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_DISEMBARKING_TRACK =
      deferredRegister.register("abandoned_disembarking_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_DISEMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_WYE_TRACK =
      deferredRegister.register("abandoned_wye_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_TURNOUT_TRACK =
      deferredRegister.register("abandoned_turnout_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_JUNCTION_TRACK =
      deferredRegister.register("abandoned_junction_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ABANDONED_LAUNCHER_TRACK =
      deferredRegister.register("abandoned_launcher_track",
          () -> new BlockItem(RailcraftBlocks.ABANDONED_LAUNCHER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_TRACK =
      deferredRegister.register("electric_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> ELECTRIC_LOCKING_TRACK =
      deferredRegister.register("electric_locking_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_BUFFER_STOP_TRACK =
      deferredRegister.register("electric_buffer_stop_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_BUFFER_STOP_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_ACTIVATOR_TRACK =
      deferredRegister.register("electric_activator_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_BOOSTER_TRACK =
      deferredRegister.register("electric_booster_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_CONTROL_TRACK =
      deferredRegister.register("electric_control_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_CONTROL_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_GATED_TRACK =
      deferredRegister.register("electric_gated_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_GATED_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_DETECTOR_TRACK =
      deferredRegister.register("electric_detector_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_COUPLER_TRACK =
      deferredRegister.register("electric_coupler_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_COUPLER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_EMBARKING_TRACK =
      deferredRegister.register("electric_embarking_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_EMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_DISEMBARKING_TRACK =
      deferredRegister.register("electric_disembarking_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_DISEMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_WYE_TRACK =
      deferredRegister.register("electric_wye_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_TURNOUT_TRACK =
      deferredRegister.register("electric_turnout_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_JUNCTION_TRACK =
      deferredRegister.register("electric_junction_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELECTRIC_LAUNCHER_TRACK =
      deferredRegister.register("electric_launcher_track",
          () -> new BlockItem(RailcraftBlocks.ELECTRIC_LAUNCHER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_TRACK =
      deferredRegister.register("high_speed_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> HIGH_SPEED_TRANSITION_TRACK =
      deferredRegister.register("high_speed_transition_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_TRANSITION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_LOCKING_TRACK =
      deferredRegister.register("high_speed_locking_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ACTIVATOR_TRACK =
      deferredRegister.register("high_speed_activator_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_BOOSTER_TRACK =
      deferredRegister.register("high_speed_booster_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_DETECTOR_TRACK =
      deferredRegister.register("high_speed_detector_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_WYE_TRACK =
      deferredRegister.register("high_speed_wye_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_TURNOUT_TRACK =
      deferredRegister.register("high_speed_turnout_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_JUNCTION_TRACK =
      deferredRegister.register("high_speed_junction_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_TRACK =
      deferredRegister.register("high_speed_electric_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_TRANSITION_TRACK =
      deferredRegister.register("high_speed_electric_transition_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_LOCKING_TRACK =
      deferredRegister.register("high_speed_electric_locking_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK =
      deferredRegister.register("high_speed_electric_activator_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_BOOSTER_TRACK =
      deferredRegister.register("high_speed_electric_booster_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_DETECTOR_TRACK =
      deferredRegister.register("high_speed_electric_detector_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_WYE_TRACK =
      deferredRegister.register("high_speed_electric_wye_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_TURNOUT_TRACK =
      deferredRegister.register("high_speed_electric_turnout_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_ELECTRIC_JUNCTION_TRACK =
      deferredRegister.register("high_speed_electric_junction_track",
          () -> new BlockItem(RailcraftBlocks.HIGH_SPEED_ELECTRIC_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_LOCKING_TRACK =
      deferredRegister.register("iron_locking_track",
          () -> new BlockItem(RailcraftBlocks.IRON_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_BUFFER_STOP_TRACK =
      deferredRegister.register("iron_buffer_stop_track",
          () -> new BlockItem(RailcraftBlocks.IRON_BUFFER_STOP_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_ACTIVATOR_TRACK =
      deferredRegister.register("iron_activator_track",
          () -> new BlockItem(RailcraftBlocks.IRON_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_BOOSTER_TRACK =
      deferredRegister.register("iron_booster_track",
          () -> new BlockItem(RailcraftBlocks.IRON_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_CONTROL_TRACK =
      deferredRegister.register("iron_control_track",
          () -> new BlockItem(RailcraftBlocks.IRON_CONTROL_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_GATED_TRACK =
      deferredRegister.register("iron_gated_track",
          () -> new BlockItem(RailcraftBlocks.IRON_GATED_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_DETECTOR_TRACK =
      deferredRegister.register("iron_detector_track",
          () -> new BlockItem(RailcraftBlocks.IRON_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_COUPLER_TRACK =
      deferredRegister.register("iron_coupler_track",
          () -> new BlockItem(RailcraftBlocks.IRON_COUPLER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_EMBARKING_TRACK =
      deferredRegister.register("iron_embarking_track",
          () -> new BlockItem(RailcraftBlocks.IRON_EMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_DISEMBARKING_TRACK =
      deferredRegister.register("iron_disembarking_track",
          () -> new BlockItem(RailcraftBlocks.IRON_DISEMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_WYE_TRACK =
      deferredRegister.register("iron_wye_track",
          () -> new BlockItem(RailcraftBlocks.IRON_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_TURNOUT_TRACK =
      deferredRegister.register("iron_turnout_track",
          () -> new BlockItem(RailcraftBlocks.IRON_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_JUNCTION_TRACK =
      deferredRegister.register("iron_junction_track",
          () -> new BlockItem(RailcraftBlocks.IRON_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> IRON_LAUNCHER_TRACK =
      deferredRegister.register("iron_launcher_track",
          () -> new BlockItem(RailcraftBlocks.IRON_LAUNCHER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_TRACK =
      deferredRegister.register("reinforced_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> REINFORCED_LOCKING_TRACK =
      deferredRegister.register("reinforced_locking_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_BUFFER_STOP_TRACK =
      deferredRegister.register("reinforced_buffer_stop_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_BUFFER_STOP_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_ACTIVATOR_TRACK =
      deferredRegister.register("reinforced_activator_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_BOOSTER_TRACK =
      deferredRegister.register("reinforced_booster_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_CONTROL_TRACK =
      deferredRegister.register("reinforced_control_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_CONTROL_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_GATED_TRACK =
      deferredRegister.register("reinforced_gated_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_GATED_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_DETECTOR_TRACK =
      deferredRegister.register("reinforced_detector_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_COUPLER_TRACK =
      deferredRegister.register("reinforced_coupler_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_COUPLER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_EMBARKING_TRACK =
      deferredRegister.register("reinforced_embarking_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_EMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_DISEMBARKING_TRACK =
      deferredRegister.register("reinforced_disembarking_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_DISEMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_WYE_TRACK =
      deferredRegister.register("reinforced_wye_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_TURNOUT_TRACK =
      deferredRegister.register("reinforced_turnout_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_JUNCTION_TRACK =
      deferredRegister.register("reinforced_junction_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> REINFORCED_LAUNCHER_TRACK =
      deferredRegister.register("reinforced_launcher_track",
          () -> new BlockItem(RailcraftBlocks.REINFORCED_LAUNCHER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_TRACK =
      deferredRegister.register("strap_iron_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> STRAP_IRON_LOCKING_TRACK =
      deferredRegister.register("strap_iron_locking_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_LOCKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_BUFFER_STOP_TRACK =
      deferredRegister.register("strap_iron_buffer_stop_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_BUFFER_STOP_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_ACTIVATOR_TRACK =
      deferredRegister.register("strap_iron_activator_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_ACTIVATOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_BOOSTER_TRACK =
      deferredRegister.register("strap_iron_booster_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_BOOSTER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_CONTROL_TRACK =
      deferredRegister.register("strap_iron_control_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_CONTROL_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_GATED_TRACK =
      deferredRegister.register("strap_iron_gated_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_GATED_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_DETECTOR_TRACK =
      deferredRegister.register("strap_iron_detector_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_DETECTOR_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_COUPLER_TRACK =
      deferredRegister.register("strap_iron_coupler_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_COUPLER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_EMBARKING_TRACK =
      deferredRegister.register("strap_iron_embarking_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_EMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_DISEMBARKING_TRACK =
      deferredRegister.register("strap_iron_disembarking_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_DISEMBARKING_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_WYE_TRACK =
      deferredRegister.register("strap_iron_wye_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_WYE_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_TURNOUT_TRACK =
      deferredRegister.register("strap_iron_turnout_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_TURNOUT_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_JUNCTION_TRACK =
      deferredRegister.register("strap_iron_junction_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_JUNCTION_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> STRAP_IRON_LAUNCHER_TRACK =
      deferredRegister.register("strap_iron_launcher_track",
          () -> new BlockItem(RailcraftBlocks.STRAP_IRON_LAUNCHER_TRACK.get(),
              new Item.Properties().tab(OUTFITTED_TRACKS_TAB)));

  public static final RegistryObject<Item> ELEVATOR_TRACK =
      deferredRegister.register("elevator_track",
          () -> new BlockItem(RailcraftBlocks.ELEVATOR_TRACK.get(),
              new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

  public static final RegistryObject<Item> IRON_CROWBAR =
      deferredRegister.register("iron_crowbar",
          () -> new CrowbarItem(2.5F, -2.8F, Tiers.IRON,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_CROWBAR =
      deferredRegister.register("steel_crowbar",
          () -> new CrowbarItem(2.5F, -2.7F, RailcraftItemTier.STEEL,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> DIAMOND_CROWBAR =
      deferredRegister.register("diamond_crowbar",
          () -> new CrowbarItem(2.5F, -2.4F, Tiers.DIAMOND,
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SEASONS_CROWBAR =
      deferredRegister.register("seasons_crowbar",
          () -> new SeasonsCrowbarItem(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TRANSITION_TRACK_KIT =
      deferredRegister.register("transition_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_TRANSITION_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_TRANSITION_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> LOCKING_TRACK_KIT =
      deferredRegister.register("locking_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_LOCKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_LOCKING_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> BUFFER_STOP_TRACK_KIT =
      deferredRegister.register("buffer_stop_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_BUFFER_STOP_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_BUFFER_STOP_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> ACTIVATOR_TRACK_KIT =
      deferredRegister.register("activator_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_ACTIVATOR_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_ACTIVATOR_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> BOOSTER_TRACK_KIT =
      deferredRegister.register("booster_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_BOOSTER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_BOOSTER_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> CONTROL_TRACK_KIT =
      deferredRegister.register("control_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_CONTROL_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_CONTROL_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> GATED_TRACK_KIT =
      deferredRegister.register("gated_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_GATED_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_GATED_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> DETECTOR_TRACK_KIT =
      deferredRegister.register("detector_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED, RailcraftBlocks.HIGH_SPEED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.HIGH_SPEED_ELECTRIC,
                  RailcraftBlocks.HIGH_SPEED_ELECTRIC_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_DETECTOR_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_DETECTOR_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> COUPLER_TRACK_KIT =
      deferredRegister.register("coupler_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_COUPLER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_COUPLER_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> EMBARKING_TRACK_KIT =
      deferredRegister.register("embarking_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED, RailcraftBlocks.REINFORCED_EMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON, RailcraftBlocks.STRAP_IRON_EMBARKING_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> DISEMBARKING_TRACK_KIT =
      deferredRegister.register("disembarking_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .setAllowedOnSlopes(true)
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_DISEMBARKING_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_DISEMBARKING_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> LAUNCHER_TRACK_KIT =
      deferredRegister.register("launcher_track_kit",
          () -> new TrackKitItem((TrackKitItem.Properties) new TrackKitItem.Properties()
              .addOutfittedBlock(TrackTypes.ABANDONED, RailcraftBlocks.ABANDONED_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.ELECTRIC, RailcraftBlocks.ELECTRIC_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.IRON, RailcraftBlocks.IRON_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.REINFORCED,
                  RailcraftBlocks.REINFORCED_LAUNCHER_TRACK)
              .addOutfittedBlock(TrackTypes.STRAP_IRON,
                  RailcraftBlocks.STRAP_IRON_LAUNCHER_TRACK)
              .tab(TAB)));

  public static final RegistryObject<Item> GOGGLES =
      deferredRegister.register("goggles",
          () -> new GogglesItem(new Item.Properties().tab(TAB)));

  public static final RegistryObject<BlockItem> MANUAL_ROLLING_MACHINE =
      deferredRegister.register("manual_rolling_machine",
          () -> new BlockItem(RailcraftBlocks.MANUAL_ROLLING_MACHINE.get(),
              new Item.Properties().tab(TAB)));

  public static final RegistryObject<BlockItem> COKE_OVEN_BRICKS =
      deferredRegister.register("coke_oven_bricks",
          () -> new BlockItem(RailcraftBlocks.COKE_OVEN_BRICKS.get(),
              new Item.Properties().tab(TAB)));

  /* ===== CRAFTING MATERIALS ===== */
  public static final RegistryObject<Item> COAL_COKE =
      deferredRegister.register("coal_coke",
          () -> new Item(new Item.Properties().tab(TAB)) {
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
              return recipeType == RailcraftRecipeTypes.BLASTING.get() ? 3200 : 0;
            }
          });

  //Plates
  public static final RegistryObject<Item> STEEL_PLATE =
      deferredRegister.register("steel_plate",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> IRON_PLATE =
      deferredRegister.register("iron_plate",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TIN_PLATE =
    deferredRegister.register("tin_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> GOLD_PLATE =
    deferredRegister.register("gold_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> LEAD_PLATE =
    deferredRegister.register("lead_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ZINC_PLATE =
    deferredRegister.register("zinc_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRASS_PLATE =
    deferredRegister.register("brass_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> INVAR_PLATE =
    deferredRegister.register("invar_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRONZE_PLATE =
    deferredRegister.register("bronze_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> COPPER_PLATE =
    deferredRegister.register("copper_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> NICKEL_PLATE =
    deferredRegister.register("nickel_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SILVER_PLATE =
    deferredRegister.register("silver_plate",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STEEL_INGOT =
      deferredRegister.register("steel_ingot",
          () -> new Item(new Item.Properties().tab(TAB)));


  public static final RegistryObject<Item> TIN_INGOT =
      deferredRegister.register("tin_ingot",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ZINC_INGOT =
      deferredRegister.register("zinc_ingot",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRASS_INGOT =
      deferredRegister.register("brass_ingot",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRONZE_INGOT =
      deferredRegister.register("bronze_ingot",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> NICKEL_INGOT =
    deferredRegister.register("nickel_ingot",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> INVAR_INGOT =
    deferredRegister.register("invar_ingot",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> LEAD_INGOT =
    deferredRegister.register("lead_ingot",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SILVER_INGOT =
    deferredRegister.register("silver_ingot",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SALTPETER_DUST =
    deferredRegister.register("saltpeter_dust",
      () -> new Item(new Item.Properties().tab(TAB)));

  // NUGGET
  public static final RegistryObject<Item> STEEL_NUGGET =
      deferredRegister.register("steel_nugget",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> TIN_NUGGET =
      deferredRegister.register("tin_nugget",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ZINC_NUGGET =
      deferredRegister.register("zinc_nugget",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRASS_NUGGET =
      deferredRegister.register("brass_nugget",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> BRONZE_NUGGET =
      deferredRegister.register("bronze_nugget",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> NICKEL_NUGGET =
    deferredRegister.register("nickel_nugget",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> INVAR_NUGGET =
    deferredRegister.register("invar_nugget",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SILVER_NUGGET =
    deferredRegister.register("silver_nugget",
      () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> LEAD_NUGGET =
    deferredRegister.register("lead_nugget",
      () -> new Item(new Item.Properties().tab(TAB)));

  // Gear
  public static final RegistryObject<Item> BUSHING_GEAR = registerBasicItem("bushing_gear");
  public static final RegistryObject<Item> TIN_GEAR = registerBasicItem("tin_gear");
  public static final RegistryObject<Item> GOLD_GEAR = registerBasicItem("gold_gear");
  public static final RegistryObject<Item> IRON_GEAR = registerBasicItem("iron_gear");
  public static final RegistryObject<Item> LEAD_GEAR = registerBasicItem("lead_gear");
  public static final RegistryObject<Item> ZINC_GEAR = registerBasicItem("zinc_gear");
  public static final RegistryObject<Item> BRASS_GEAR = registerBasicItem("brass_gear");
  public static final RegistryObject<Item> INVAR_GEAR = registerBasicItem("invar_gear");
  public static final RegistryObject<Item> STEEL_GEAR = registerBasicItem("steel_gear");
  public static final RegistryObject<Item> BRONZE_GEAR = registerBasicItem("bronze_gear");
  public static final RegistryObject<Item> COPPER_GEAR = registerBasicItem("copper_gear");
  public static final RegistryObject<Item> NICKEL_GEAR = registerBasicItem("nickel_gear");
  public static final RegistryObject<Item> SILVER_GEAR = registerBasicItem("silver_gear");

  // circuits
  public static final RegistryObject<Item> CONTROLLER_CIRCUIT =
      deferredRegister.register("controller_circuit",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> RECEIVER_CIRCUIT =
      deferredRegister.register("receiver_circuit",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_CIRCUIT =
      deferredRegister.register("signal_circuit",
          () -> new Item(new Item.Properties().tab(TAB)));

  // rails
  public static final RegistryObject<Item> WOODEN_RAIL =
      deferredRegister.register("wooden_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STANDARD_RAIL =
      deferredRegister.register("standard_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ADVANCED_RAIL =
      deferredRegister.register("advanced_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> REINFORCED_RAIL =
      deferredRegister.register("reinforced_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> HIGH_SPEED_RAIL =
      deferredRegister.register("high_speed_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> ELECTRIC_RAIL =
      deferredRegister.register("electric_rail",
          () -> new Item(new Item.Properties().tab(TAB)));

  // misc crafting units
  public static final RegistryObject<Item> WOODEN_TIE =
      deferredRegister.register("wooden_tie",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STONE_TIE =
      deferredRegister.register("stone_tie",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> REBAR =
      deferredRegister.register("rebar",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> WOODEN_RAILBED =
      deferredRegister.register("wooden_railbed",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> STONE_RAILBED =
      deferredRegister.register("stone_railbed",
          () -> new Item(new Item.Properties().tab(TAB)));

  public static final RegistryObject<Item> SIGNAL_LAMP =
      deferredRegister.register("signal_lamp",
          () -> new Item(new Item.Properties().tab(TAB)));

  /* ===== BUCKETS ===== */

  public static final RegistryObject<Item> CREOSOTE_BUCKET =
      deferredRegister.register("creosote_bucket",
          () -> new BucketItem(RailcraftFluids.CREOSOTE, new Item.Properties().tab(TAB)));

  // UTILS
  private static <B extends Block> Function<Block, BlockItem> blockItemFactory(
      CreativeModeTab tab) {
    return block -> new BlockItem(block, new Item.Properties().tab(tab));
  }

  private static RegistryObject<Item> registerBasicItem(String registerName) {
    return registerBasicItem(registerName, TAB);
  }

  private static RegistryObject<Item> registerBasicItem(String registerName, CreativeModeTab tab) {
    return deferredRegister.register(registerName,
      () -> new Item(new Item.Properties().tab(tab)));
  }
}
