<template>
  <div id="div-blocklevel">
      <span @click="jumpToSubSection">{{sectionName}}</span>
      <span>lv {{sectionLv}}</span>
  </div>
</template>

<script>
export default {
  props:{
    sectionId:Number,
    sectionName:String,
    sectionLv:String,
  },
  methods:{
    jumpToSubSection() {
      let that = this;
      localStorage.setItem("sectionId", this.sectionId);
      this.$router.push({
        name: "plate",
        params: {
          sectionId: this.sectionId,
          token: localStorage.getItem('token'),
        },
      }).catch(err =>{console.log(err)});
      window.open("/#/platepage", (name = "_self"));
    },
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