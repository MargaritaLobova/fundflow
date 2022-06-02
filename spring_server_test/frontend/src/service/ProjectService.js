import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080/",
});

const responseBody = (response) =>
  response.data.projects;
/*const responseSingle = (response) => response;*/

const request = {
  getAll: (url) => instance.get(url).then(responseBody),
/*  getSingle: (url) => instance.get(url).then(responseSingle),
  updateBanner: (url, body) =>
    instance.put(url, body).then(responseSingle),
  deleteBanner: (url) => instance.delete(url).then(responseSingle),
  post: (url, body) =>
    instance.post(url, body).then(responseSingle),*/
};

export const ProjectService = {
  getProjects: () => request.getAll("api/v1/project/all/"),
  /*getBanner: (id)=>
request.getSingle(`banners/${id}`),
  updateBanner: (id, body) =>
request.updateBanner(`banners/${id}`, body),
  deleteBanner: (id)=>
request.deleteBanner(`banners/${id}`),
  postBanner: (body) =>
request.post("banners/", body),*/
};