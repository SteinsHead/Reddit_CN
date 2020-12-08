<template>
  <div id="reply-div-box">
    <span class="reply-span">{{from}}&nbsp;回复说:&nbsp;{{content}}</span> 
    <span @click="deleteThisReply" v-if="showButtonDeleteThisReply" class="reply-span">删除回复</span>
  </div>
</template>

<script>
export default {
    props:{
        reply:Object,
        from:String,
        to:String, //没用
        content:String,
        showButtonDeleteThisReply:Boolean,
    },
    data() {
        return {
        }
    },
    methods:{
        deleteThisReply:function(){
            let that =this;
            this.$axios.post('/postReply/banPostReply',null,{
                params:{
                    sectionId:localStorage.getItem('Sid'),
                    sectionPostId:localStorage.getItem('id'),
                    postFloorId:this.$parent.$parent.floorIds[this.$parent.storey-1],
                    postReplyId:this.reply.postReplyId,
                },
                headers:{
                    token:localStorage.getItem('token'),
                }
            }).then(function(response){
                if(response.data){
                    that.$router.replace({
                        path:'/jump',
                        name:'jump'
                    }).catch(err =>{console.log(err)})
                    alert('删除回复成功')
                }
            })
        }
    }
}
</script>

<style>
#reply-div-box{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}
.reply-span{
    padding-left: 20px;
    padding-right: 20px;
    display: flex;
    justify-content: left;
    font-size: 12px;
    cursor: pointer;
}
</style>