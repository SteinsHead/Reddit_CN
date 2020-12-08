<template>
  <div id="box">
      <div id="head"><p>{{sectionName}}</p></div>

      <div><span id="clickHere" @click="toTie">{{sectionPostName}}</span></div>

      <div class="row-flex"><p>创建时间: {{sectionPostTime}}</p> <p>帖子楼层数: {{sectionPostFloor}}</p></div>
  </div>
</template>

<script>
export default {
    props:{
        sectionPostId:Number,
        sectionId:Number,
        sectionName:String,
        sectionPostName:String,
        sectionPostTime:String,
        sectionPostFloor:Number
    },
    methods:{
        toTie:function(){
            this.$router.push({
                name:"tie",
                params:{
                id:this.sectionPostId,
                Sid:this.sectionId,
                content:this.sectionPostName,
                }
            }).catch(err =>{console.log(err)});
            localStorage.setItem('id',this.sectionPostId);
            localStorage.setItem('Sid',this.sectionId);
            localStorage.setItem('content',this.sectionPostName);
        },
    }
}
</script>

<style>
#clickHere{
    cursor: pointer;
}
.row-flex{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#box{    
    border-radius: 5px;
    margin-top: 10px;
    background-color: white;
    border: 1px solid white;
    display: flex;
    flex-direction: column;
}
#head{
    margin-left: 20px;
    display:flex;
    justify-content: left;
    align-items: center;

}
p{
    font-size: 12px;
}
</style>