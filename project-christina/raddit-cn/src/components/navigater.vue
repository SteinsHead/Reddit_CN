<template>
  <div class="nav">
      <p :style="textStyle">{{navName}}</p>
  </div>
</template>

<script>
export default {
data() {
    return {
        
    }
},
props: {
    navName: "",
    textStyle: {
        
    },
},
}
</script>

<style>
.nav {
    margin: 20px;
    background-color: #10098F;
    width: 65px;
    height: 50px;
}
</style>