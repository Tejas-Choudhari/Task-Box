import httpClient from "../API/http-common";


export const readAll = () => {
    return httpClient.get("/getall");
}

export const saveNotes =(note) => {
    return httpClient.post("/save",note);
}

export const readOne =(id) => {
    return httpClient.get(`/task/${id}`);
}

export const deleteOne =(id) => {
    return httpClient.delete(`/del/${id}`);
}

export const updateOne =(note) => {
    return httpClient.put(`/update`,note);
}