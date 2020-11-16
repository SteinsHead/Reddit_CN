<template>
  <div id="page">
      <topbanner></topbanner>
      <areablock></areablock>
  </div>
</template>

<script>
import banner from '@/components/topBanner';
import areablock from '@/components/areaBlock';
export default {
name: "page",
data() {
    return {
        
    }
},
components: {
    topbanner: banner,
    areablock: areablock,
},

}
</script>

<style>
#page {
    display: flex;
    flex-wrap: wrap;
}
</style>