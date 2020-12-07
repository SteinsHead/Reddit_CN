<template>
  <div id="add-poster">
    <el-form ref="form" :model="form" label-width="80px" style="margin: 10px">
      <el-upload
        action=""
        list-type="picture-card"
        :http-request="sendRealRequest"
        :file-list="fileList"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :on-success="uploadSuccess"
        :on-error="uploadError"
      >
      </el-upload>
      <el-form-item label="帖子内容" style="margin: 10px">
        <el-input type="textarea" v-model="form.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即发帖</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "addPoster",
  data() {
    return {
      form: {
        desc: "",
      },
      fileList: [],
      photoUrl: "",
    };
  },
  props: {
    token: {
      type: String,
    },
    sectionId: {
      type: Number,
    }
  },
  methods: {
    sendRealRequest(params) {
      console.log('param is '+params.file.type);
      let that = this;
      let file = params.file;
      that.uploadFile(file);
      console.log("hh");
    },
    uploadFile(file) {
      let that = this;
      let param = new FormData();
      param.append("file", file);
      that
        .axios({
          method: "post",
          url: "/uploadPhoto",
          data: param,
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then(function (response) {
          console.log(response);
          console.log(response.data);
          that.photoUrl = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    onSubmit() {
      console.log("submit!");
      let that = this;
      console.log(that.form.desc);
      that.axios({
        method: 'post',
        url: '/sectionPost/insertSectionPost',
        params: {
          sectionId: that.sectionId,
          sectionPostName: that.form.desc,
          sectionPostPhoto: that.photoUrl,
        },
        headers: {
          token: that.token,
        },
      })
      console.log(that.photoUrl);
      window.open('/#/platepage', '_self');
    },
    handleRemove(file) {
      console.log(file);
    },
    handlePictureCardPreview(file) {
      console.log(file);
    },
    handleDownload(file) {
      console.log(file);
    },
    uploadSuccess(response, file, fileList) {
      let that = this;
      console.log("上传文件成功response" + response);
      console.log("上传文件成功file" + file);
      console.log("上传文件成功fileList" + fileList);
      that.fileList.push(response);
    },
    uploadError(err, file, fileList) {
      console.log("上传文件失败err" + err);
      console.log("上传文件失败file" + file);
      console.log("上传文件失败fileList" + fileList);
    },
  },
};
</script>

<style>
</style>