<template>
  <div id="box">
      <div id="head-Floor-div"><p>{{sectionName}}</p>  <p>{{sectionPostName}}</p></div>

      <div><span id="clickHere" @click="toTie">{{postFloorIntroduce}}</span></div>

      <div class="row-flex"><p>楼层创建时间: {{postFloorTime}}</p> <p>楼层回复数: {{postFloorReply}}</p></div>
  </div>
</template>

<script>
export default {
    props:{
        sectionPostId:Number,
        sectionId:Number,
        postFloorIntroduce:String,
        sectionName:String,
        sectionPostName:String,
        postFloorTime:String,
        postFloorReply:Number
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
            localStorage.setItem('isShowMineFloor',true);
            localStorage.setItem('id',this.sectionPostId);
            localStorage.setItem('Sid',this.sectionId);
            localStorage.setItem('content',this.sectionPostName);
        },
    }
}
</script>

<style>
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
#head-Floor-div{
    margin-left: 20px;
    margin-right:20px;
    display:flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;

}
p{
    font-size: 12px;
}
#clickHere{
    cursor: pointer;
}
</style>