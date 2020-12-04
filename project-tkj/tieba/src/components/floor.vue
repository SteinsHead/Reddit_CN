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
            <span class="span1">{{replyTime}}</span>
            <span class="span1" id="replyThisFloor" @click="replyThisFloor">回复本层</span>
            <span class="span1" id="show-reply" @click="showReply">查看评论({{replyNum}})</span>
        </div>
        <div id="floor-reply" v-show="isShowReply" v-for="mReply in reply" :key="mReply.id">
            <reply @click.native="floorReply(mReply.from)" :from="mReply.from" :to="mReply.to" :content="mReply.replyContent"></reply>
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
        replyTime:String,
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
        }
    },
    computed:{
        getTime:function(){
            let data = new Date();
            return data.toLocaleString();
        }
    },
    methods: {
        replyThisFloor:function(){
            this.isShowReply = !this.isShowReply;
            this.$parent.isShowCommet =!this.$parent.isShowCommet;
            this.$parent.To = this.name;
            this.$parent.where = this.storey;
        },
        showReply:function(){
            this.isShowReply = !this.isShowReply;
        },
        floorReply:function(From){
                this.$parent.isShowCommet =!this.$parent.isShowCommet;
                this.$parent.To = From;
                this.$parent.where = this.storey;
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
#replyThisFloor{
    cursor: pointer;
}
</style>