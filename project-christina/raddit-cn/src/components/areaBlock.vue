<template>
  <div id="area">
      <div class="title">
          <p>{{title}}</p>
      </div>
      <div class="blockInfo">
          <p>{{blockName}}</p>
          <div class="img">
              <img src="https://cdn.jsdelivr.net/gh/SteinsHead/ImageBed/img/2020/1597120574740.jpg" alt="" srcset="">
          </div>
      </div>
  </div>
</template>

<script>
export default {
name: "area",
data() {
    return {
        title: "分区A",
        blockName: "板块A",
        
    }
},
components:{

},
}
</script>

<style>

#area {
    margin: 50px;
    height: 200px;
    width: 150px;
    background-color: skyblue;
}

.blockInfo {
    margin: 0 auto;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    width: 80px;
    background-color: aquamarine;
}

.img{
    margin: 0 auto;
    width: 50px;
    height: 50px;
}

.img img{
    height: 100%;
}

</style>