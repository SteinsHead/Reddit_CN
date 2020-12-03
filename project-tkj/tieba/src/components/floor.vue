<template>
  <div id="floor">
      <div id="floor-body">
        <div id="owner-message">
            <img :src="headImage" />
            <span class="span1">{{name}}</span>
            <div>
                <span class="span1" id="level">lv:{{level}}</span>
                <span class="span1" id="achievement">{{achievement}}</span>
            </div>
        </div>
        <div id="floor-content">
                <span class="span1">{{content}}</span>
        </div>
      </div>
      <div id="floor-bottom">
        <div id="floor-message">
            <span class="span1">{{storey}}楼</span>
            <span class="span1">{{getTime}}</span>
            <span class="span1" id="show-reply" @click="showReply">回复({{replyNum}})</span>
        </div>
        <div id="floor-reply" v-show="isShowReply" v-for="mReply in reply" :key="mReply.id">
            <reply :from="mReply.from" :to="mReply.to" :content="mReply.replyContent"></reply>
        </div>
  </div>
  </div>
  
</template>

<script>
import reply from '@/components/reply.vue';

export default {
    components: {
       reply:reply
    },
    props:{
        headImage:String,
        name:String,
        level:Number,
        achievement:String,
        content:String,
        storey:Number,
        replyNum:Number,
        reply:{
            type:Array,
            default(){
                return [] 
            }
        }
         
    },
    data() {
        return {
            isShowReply:false,
            // reply:4,
            // headImage:"https://ae03.alicdn.com/kf/H3e674eece2004db28ae4387dae2406eap.jpg",
            // name:"爱唱歌的向日葵",
            // level:12,
            // achievement:"后起之秀",
            // content:"王世钢喜欢马晨峰是怎么回事呢，为什么王世钢喜欢马晨峰呢，王世钢喜欢马晨峰就是这么回事"
        }
    },
    computed:{
        getTime:function(){
            let data = new Date();
            return data.toLocaleString();
        }
    },
    methods: {
        showReply:function(){
            this.isShowReply = !this.isShowReply;
        }
    },
}
</script>

<style>
#floor{
    border: white 1px solid;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
#floor-body{
    position: relative;
    display: flex;
    flex-direction: row;
    justify-content: left;
}
#owner-message{
    width: 10%;
    border: 1px white solid;
    padding: 5px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
#owner-message > img{
    width: 48px;
    height: 48px;
}
.span1{
    font-size: 12px;
}
#level{
    color: red;
}
#achievement{
    color: green;
}
#floor-content{
    padding:5px;
}
#floor-message{
    border: 1px white solid;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}
#show-reply{
    cursor: pointer;
}
</style>