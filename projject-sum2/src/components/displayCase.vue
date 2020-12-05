<template>
    <div>
        <div id="box">
            <img id="image" :src="image" alt=""/> 
        </div>
        <img id="fix" @click="stick" src="../assets/dingzhu.png" title="点击固定" />
    </div>
</template>

<script>

export default {
    data() {
        return {
        }
    },
    props:{
        image:String
    },
    methods:{
        stick:function(){
            let e = document.getElementById("box");
            let e2 = document.getElementById("fix");
            let h = e.scrollTop;
            if(e.style.overflow == 'hidden'){
                e.style.overflow = 'scroll';
                e.style.marginTop = 0;
                e2.title = '点击固定';
            }
            else{
                e.style.overflow = 'hidden';
                e.style.marginTop = -h;
                e2.title = '点击取消固定';
            }
        }
    }
}


</script>

<style scope>
#box{
    width: 1000px;
    height: 150px;
    overflow:scroll;
}
#image{
    width: 100%;
}
::-webkit-scrollbar{
    display:none;
    
}
#fix{
    position: relative;
    cursor: pointer;
    width: 20px;
    height: 20px;
    top: -28px;
    right: -46%;
}
</style>