<template>
  <div id="page">
    <topbanner></topbanner>
    <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
    <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
    <naviGater :navName="navname" :textStyle="textcolor"></naviGater>
    <div class="block">
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
      <areablock :title="blockLabel" :blockName="blockname"></areablock>
    </div>
  </div>
</template>

<script>
import banner from "@/components/topBanner";
import areablock from "@/components/areaBlock";
import navigater from "@/components/navigater";
export default {
  name: "page",
  data() {
    return {
      blockLabel: "分区A",
      blockname: "板块A",
      navname: "Raddit",
      textcolor: {
          "color": "white",
      }
    };
  },
  components: {
    topbanner: banner,
    areablock: areablock,
    naviGater: navigater,
  },
};
</script>

<style>
#page {
  display: flex;
  flex-wrap: wrap;
}

.block {
  display: flex;
  flex-wrap: wrap;
}
</style>