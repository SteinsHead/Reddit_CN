<template>
  <div id="message-body">
    <div id="left-body">
        <div id="option" ><span @click="reply">回复我的</span><div class="triple-right"></div></div>
        <div id="option" ><span @click="offical">官方消息</span><div class="triple-right"></div></div>
    </div>

    <div id="right-body">
        <div id="msg-box" v-if="replyMe">
            <simpleMsg from="王世钢" to="我" content="我是大sz"></simpleMsg>
            <simpleMsg from="马晨峰" to="我" content="王世钢是大sz"></simpleMsg>
            <simpleMsg from="满显凡" to="我" content="他俩都是大sz"></simpleMsg>
        </div>
        <div id="msg-box" v-if="officalMsg">
            <simpleMsg from="vip小助手" to="我" content="冲一年赠送6个月哦！"></simpleMsg>
            <simpleMsg from="vip小助手" to="我" content="年费会员只要99！"></simpleMsg>
            <simpleMsg from="vip小助手" to="我" content="超级酬宾大放送"></simpleMsg>
        </div>
    </div>
    <toTop></toTop>
  </div>
</template>

<script>
import simple_msg from "@/components/simple_msg.vue"
import toTop from "@/components/toTop.vue"
export default {
    components:{
        simpleMsg:simple_msg,
        toTop,toTop
    },
    methods: {
        reply:function(){
            this.replyMe = true;
            this.officalMsg = false;
        },
        offical:function(){
            this.officalMsg = true;
            this.replyMe = false;
            
        }
    },
    data() {
        return {
            replyMe:false,
            officalMsg:false,
        }
    },
}
</script>

<style>
#option{
    position: relative;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50px;
    border-bottom: 1px solid #376aac;
    background-color: #2059a3;
    cursor: pointer;
}
#option:hover > div{
    border-right-color: #eeeeec;
}
#option > span{
    position: relative;
}
/* 右三角 */
#option > div{
    position: absolute;
    right: 0;
    width:0;
    height:0;
    overflow:hidden;
    font-size: 0;     /*是因为, 虽然宽高度为0, 但在IE6下会具有默认的 */
    line-height: 0;  /* 字体大小和行高, 导致盒子呈现被撑开的长矩形 */
    border-width:10px;
    border-style:solid dashed dashed dashed;/*IE6下, 设置余下三条边的border-style为dashed,即可达到透明的效果*/
    border-color: transparent #2059a3 transparent transparent;
}
#message-body{
    width: 80%;
    display: flex;
    flex-direction: row;
    margin-top: 30px;
    background-color: #eeeeec;
}
#left-body{
    display: flex;
    flex-direction: column;
    width: 15%;
    height: 800px;
    background-color: #3f7ac6;
}
#right-body{
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 85%;
}
#msg-box{
    width: 90%;
}
</style>