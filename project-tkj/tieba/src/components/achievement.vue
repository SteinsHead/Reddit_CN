<template>
  <div id="achievement-div">
      <div id="achievement-p">
        <p id="achievement-content">
            {{achievementDescribe}}
        </p>
        <p id="evolve">
            成就：{{achievementName}}&nbsp;&nbsp;&nbsp;&nbsp;完成进度：{{nowEvolve}}/{{allEvolve}}
        </p>
       
      </div>
      <myButton @click.native="getAchievement" :msg="msg"></myButton>
  </div>
</template>

<script>
// 使用说明：
// 三个参数：
// achievementDescribe 成就描述
// nowEvolve：当前进度
// allEvolve：总进度
// achievementName 成就名
import myButton from "@/components/button.vue"
export default {
    components:{
        myButton:myButton
    },
    props:{
        achievementDescribe:String,
        nowEvolve:Number,
        allEvolve:Number,
        achievementName:String,
    },
    watch: {
        nowEvolve:function(newVal,oldVal){
            if(newVal == this.allEvolve){
                this.msg = "点击领取";
                this.canIGet = true;
            }
        }
    },
    data() {
        return {
            msg:"未完成",
            canIGet:false
        }
    },
    methods: {
        getAchievement:function(){
            if(this.msg != "已拥有" && this.canIGet)
                this.msg = "已拥有";
            //获得此成就,,,,,
        }
    },
}
</script>

<style>
#achievement-div{
    margin-top: 25px;
    width: 80%;
    height: 80px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    padding-left: 20px;
    padding-right: 20px;
    align-content: center;
    background-color: white;
    border-radius: 5px;

}
#achievement-content{
   width: 100%;
   display: flex;
   justify-content: left;
   margin-left: 30px;
}
#achievement-p{
    font-size: 12px;
    display: flex;
    flex-direction: column;
    
    align-items: center;
}
#evolve{
    margin-left: 400px;
}
</style>