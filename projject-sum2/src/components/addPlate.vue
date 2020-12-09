<template>
  <div id="add-plate">
    <el-form ref="form" :model="form" label-width="100px" style="margin: 10px">
      <el-from-item label="上传头像">
        <el-upload
          action=""
          list-type="picture-card"
          :http-request="sendRealRequest"
          :file-list="fileList"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-success="uploadSuccess"
          :on-error="uploadError"
        ></el-upload>
      </el-from-item>
      <el-form-item label="板块名称" style="margin: 10px">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="板块介绍" style="margin: 10px">
        <el-input type="textarea" v-model="form.desc"></el-input>
      </el-form-item>
      <el-form-item label="选项">
        <el-button type="primary" @click="onSubmit">创建新板块</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "addPlate",
  data() {
    return {
      form: {
        name: "",
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
  },
  methods: {
    sendRealRequest(params) {
      console.log("param is " + params.file.type);
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
            token: that.token,
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
      that
        .axios({
          method: "post",
          url: "/section/insertSection",
          params: {
            sectionName: that.form.name,
            sectionIntroduce: that.form.desc,
            sectionPhoto: that.photoUrl,
          },
          headers: {
            token: that.token,
          },
        })
        .then(function (response) {
          console.log(response);
        })
        .then(function (error) {
          console.log(error);
        });
      console.log(that.form.name);
      console.log(that.form.desc);
      console.log(that.photoUrl);
      setTimeout(function () {
        location.reload();
      }, 500);
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