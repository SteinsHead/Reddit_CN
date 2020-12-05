<template>
<div id="tie-page">
<div id="theme"><span>{{theme}}</span></div>
<div id="tie-body" v-for="count in floorN" :key="count"> 
    <floor :storey="count" :headImage="headImage[count-1]" :name="name[count-1]" 
    :level="level[count-1]" :achievement="achievement[count-1]" :replyNum="getReplyNum(count-1)"
    :reply="reply[count-1]" :content="content[count-1]" :replyTime="replyTime[count-1]"></floor>
    
</div>
<commet @click.native="showCommet"></commet>
    <textarea id="textarea" v-if="isShowCommet"></textarea>
    <button id="send" @click="sendCommet" v-if="isShowCommet">发送</button>
<toTop></toTop>
</div>  
</template>

<script>
import floor from "@/components/floor.vue";
import toTop from '@/components/toTop.vue';
import commet from '@/components/commet.vue';
export default {
    components:{
        floor:floor,
        toTop:toTop,
        commet:commet,
    },
    created:function(){
        
    },
    methods: {
        sendCommet:function(){
                let content = document.getElementById('textarea').value;
                console.log(content);
                let data = new Date();
            if(this.where == -1){    
                if(content.length == 0){
                    alert("请输入内容");
                }
                else{
                    this.floorN +=1;
                    this.headImage.push("");
                    this.name.push("cnm");
                    this.level.push(23);
                    this.achievement.push("神");
                    this.content.push(content);
                    this.reply.push([]);
                    this.replyTime.push(data.toLocaleString());
                    document.getElementById('textarea').value = "";
                    this.isShowCommet = false;
                    alert("评论成功");
                    
                }
            }
            else{
                if(content.length == 0){
                    alert("请输入内容");
                }
                else{
                    let obj = Object.create({id:this.reply[this.where-1].length+1,from:this.From,to:this.To,replyContent:content});
                    this.reply[this.where-1].push(obj);
                    alert("评论成功");
                    this.isShowCommet = false;
                    this.where = -1;
                }
            }
        },
        showCommet:function(){
            this.isShowCommet = !this.isShowCommet;
        },
        floorReply:function(){
            console.log("test");
           

        }
    },
    computed:{
        //获取回复数
        getReplyNum(storey){
            return function(storey){
                if(this.reply[storey] != null){
                    return this.reply[storey].length;
                }
                else{
                    return 0;
                }
            }
        }
    },
    data() {
        return {
            token:"",
            From:"aaaa",
            To:null,
            where:-1,
            isShowCommet:false,
            floorN:10,
            theme:"关于王世钢喜欢马晨峰这件事",
            content:["但爱你感动功能区","sdad","但爱你能dfsd区","但爱你x功能区","fe",
            "但爱你感动功能ff区","但爱你感动功aa能区","但爱你ggg感动功能区","但爱你感动df功能区","但爱你sdas动功能区"],
            headImage:["https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
                       "https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg"], 
            name:["爱唱歌的向日葵","光明之魂","神龙","大灭","诺手","卡卡西","茶壶","水杯","键盘侠","小萌心"],
            level:[12,10,9,8,7,6,5,4,3,1],
            achievement:["后起之秀","无称号","无称号","无称号","无称号","无称号","无称号","无称号","无称号","萌新"],
            replyNum:[2,2,2,2,2,0,0,0,0,0],
            reply:[[{id:1,from:"a",to:"b",replyContent:"cnm"},{id:2,from:"b",to:"a",replyContent:"wcnm"}],
                    [{id:1,from:"b",to:"a",replyContent:"wcnm"}],[],[],[],[],[],[],[],[]],
            replyTime:["1","11","111","1111","1","11","111","1111","1","11"]
        }
    },
}
</script>

<style>
#tie-page{
    background-color: #eeeeec;
    width: 90%;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#theme{
    display: flex;
    align-items: center;
    justify-content: left;
    margin-top: 20px;
    font-size: 18px;
}
textarea{
    position: fixed;
    bottom: 20px;
    left: 10%;
    width: 80%;
    height: 200px;
    resize: none;
}
#send{
    position: fixed;
    bottom: 20px;
    right: 10%;
    width: 50px;
    height: 20px;
}
</style>