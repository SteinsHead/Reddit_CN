<template>
  <div id="button_div">
      <button :style="style_parameter" type="button">{{msg}}</button>
  </div>
</template>

<script>
export default {
    props:{
        msg:String,
        style_parameter: { 

        }
    }
}
</script>

<style scoped>
#button_div{
    display: flex;
    align-items: center;
}
button{
    background-color: white;
    border: 1px ridge;
    font-weight: 300;
    padding: 0;
    font-size: 10px;
    width: 60px;
    height: 30px;
    transition: .5s ease-in-out;
    cursor: pointer;
    outline: none;
}
</style>