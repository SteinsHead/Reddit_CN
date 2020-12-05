<template>
  <div>
      <img id="frame" :src="imageSrc" />
  </div>
</template>

<script>
export default {
    props:{
        imageSrc:String
    }
}
</script>

<style scope>
    #frame{
        position: relative;
        top: -40px;
        left: -400px;
        margin-left: 30px;
        width: 150px;
        height: 150px;
        border: 3px solid white;
        z-index: 2;
        
    }
</style>