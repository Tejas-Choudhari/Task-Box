import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { readOne, deleteOne } from "../services/notes.service";

const NoteViewComponent = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [title, setTitle] = useState('');
  const [body, setBody] = useState('');
  const [updatedAt, setUpdatedAt] = useState('');

  const getNoteById = async () => {
    try {
      const response = await readOne(id);
      const existingNote = response.data;

      setTitle(existingNote.title);
      setBody(existingNote.body);
      setUpdatedAt(existingNote.updatedAt);
    } catch (error) {
      console.error('Error occurred while retrieving the data from API');
    }
  }

  const deleteNote = async () => {
    try {
      await deleteOne(id);
      navigate("/")
    } catch (error) {
      console.error("Error occurred while deleting the Task")
    }
  }

  useEffect(() => {
    if (id) {
      getNoteById(id);
    }
  }, [id]);

  return (
    <div style={{ backgroundColor: "#ffe4c4", minHeight: "100vh" }}>
      <div style={{ textAlign: "center" }}>
        <h1 style={{ fontSize: "24px" }}>Task Details</h1>
        <hr style={{ width: "80%" }} />
        <h2 style={{ fontSize: "20px" }}>{title}</h2>
        <p style={{ fontSize: "14px", color: "#888" }}>
          Posted On {new Date(updatedAt).toDateString()} by Tejas-Choudhari
        </p>
      </div>
      <div style={{ margin: "20px 0" }} dangerouslySetInnerHTML={{ __html: body }}></div>
      <div style={{ display: "flex", justifyContent: "center" }}>
        <button
          style={{
            backgroundColor: "#ff0000",
            color: "#fff",
            padding: "10px 20px",
            border: "none",
            borderRadius: "5px",
            cursor: "pointer",
          }}
          onClick={deleteNote}
        >
          Delete
        </button>
        <Link
          to={`/editnote/${id}`}
          style={{
            marginLeft: "10px",
            textDecoration: "none",
            color: "#007bff",
          }}
        >
          Edit
        </Link>
        <Link
          to="/"
          style={{
            marginLeft: "10px",
            textDecoration: "none",
            color: "#007bff",
          }}
        >
          Back To Tasks
        </Link>
      </div>
    </div>
  );
}

export default NoteViewComponent;
