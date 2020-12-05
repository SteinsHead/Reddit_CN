<template>
  <div id="div-blocklevel">
      <span>{{sectionName}}</span>
      <span>lv {{sectionLv}}</span>
  </div>
</template>

<script>
export default {
  props:{
    sectionName:String,
    sectionLv:String,
  }
}
</script>

<style>
#div-blocklevel{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 80px;
    height: 120px;
    background-color: violet;
    border-radius: 5px;
    box-shadow: 1px 1px 1px black;
}
</style>