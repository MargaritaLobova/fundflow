import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080/",
});

const responseBody = (response) =>
  response.data.status;
/*const responseSingle = (response) => response;*/

const request = {
  get: (url, body) => instance.post(url, body).then(responseBody),
  post: (url, body) => instance.post(url, body).then(responseBody),
  /*  getSingle: (url) => instance.get(url).then(responseSingle),
    updateBanner: (url, body) =>
      instance.put(url, body).then(responseSingle),
    deleteBanner: (url) => instance.delete(url).then(responseSingle),
    post: (url, body) =>
      instance.post(url, body).then(responseSingle),*/
};

export const UserService = {
  getUser: (body) => request.get(`api/v1/auth/`, body),
  createUser: (body) => request.post('api/v1/register/',body),
  /*getBanner: (id)=>
request.getSingle(`banners/${id}`),
  updateBanner: (id, body) =>
request.updateBanner(`banners/${id}`, body),
  deleteBanner: (id)=>
request.deleteBanner(`banners/${id}`),
  postBanner: (body) =>
request.post("banners/", body),*/
};