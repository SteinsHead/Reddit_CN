<template>
<div id="container">
    <displayCase :image="image"></displayCase>
    <imageFrame :imageSrc="image"></imageFrame>
    <div id="mainbox">
        <span @click="showRouter" id="username">{{name}}</span>
        <span id="myCoin">我的金币:{{coin}}</span>
        <banner @listenToChildEvent="showMsg"></banner>
        
        <div v-if="content_control == 1" id="contentbox1">
            <div id="level">
                <blockLv></blockLv>
            </div>
            <div id="level">
                <blockLv></blockLv>
            </div>
        </div>

        <div v-if="content_control == 2" id="contentbox">
            <achievement achievementName="魔法师" achievementDescribe="ads" nowEvolve="10" allEvolve="10"></achievement>
            <achievement achievementName="大魔法师" achievementDescribe="gdddvsv" nowEvolve="6" allEvolve="10"></achievement>
            <achievement achievementName="超级魔法师" achievementDescribe="zczcz" nowEvolve="3" allEvolve="10"></achievement>
            <achievement achievementName="恶魔" achievementDescribe="ghngfnf" nowEvolve="2" allEvolve="10"></achievement>
            <achievement achievementName="我曾踏足山峰" achievementDescribe="wrwev" nowEvolve="11" allEvolve="100"></achievement>
            <achievement achievementName="也曾跌落低谷" achievementDescribe="hahaha" nowEvolve="10" allEvolve="1000"></achievement>

        
        </div>
        <div v-if="content_control == 3" id="contentbox">
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
        </div>
        <div v-if="content_control == 4" id="contentbox">
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
            <simpleTie block="游戏" owner="刚刚" theme="啊哈哈哈哈哈啊哈哈哈哈哈"></simpleTie>
        </div>
    </div>
    <!--返回顶部-->
    <toTop></toTop>
</div>
</template>

<script>
import image1 from "@/assets/二乔.jpg"

import simple_tie from "@/components/simple_tie.vue"
import toTop from "@/components/toTop.vue"
import achievement from "@/components/achievement.vue"
import displayCase from "@/components/displayCase.vue"
import imageFrame from "@/components/imageFrame.vue"
import banner from "@/components/banner.vue"
import blockLv from "@/components/blockLv.vue"
import BlockLv from '../components/blockLv.vue'
import Achievement from '../components/achievement.vue'
import Simple_tie from '../components/simple_tie.vue'
export default {
    components:{
        displayCase:displayCase,
        imageFrame:imageFrame,
        banner:banner,
        blockLv:blockLv,
        toTop:toTop,
        achievement:achievement,
        simpleTie:simple_tie      
    },
    data() {
        return {
            content_control:1,
            name:"  人定胜天!",
            coin:20,
            image:image1,
        }
    },
    methods: {
        showMsg:function(data){
            this.content_control = data;
        },
        showRouter:function(){
            console.log(this.$route.params.token);
        }
    },
}
</script>

<style>
#username{
    position: relative;
    left: -200px;
}
#mainbox{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: #eeeeec;
    position: relative;
    top: -120px;

}
#contentbox{
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: rgb(235, 243, 247);
    position: relative;
    top: -25px;
    width: 1000px;
    height: 1000px;
    border: 2px solid white;
}
#contentbox1{
    display:flex;
    background-color: rgb(235, 243, 247);
    position: relative;
    top: -25px;
    width: 1000px;
    height: 1000px;
    border: 2px solid white;
}
#level{
    position: relative;
    margin: 30px;
}
#myCoin{
    margin-top: 30px;
    font-size: 12px;
    position: relative;
    left: -200px;
}
</style>