import React, { useEffect, useState } from "react";
import { readAll } from "../services/notes.service";
import { Link } from "react-router-dom";

const Notes = () => {
  const [notes, setNotes] = useState([]);

  useEffect(() => {
    readAll()
      .then((response) => {
        console.log('Received the response from API', response.data);
        setNotes(response.data);
      })
      .catch((error) => {
        console.log('Error occurred', error);
      });
  }, []);

  return (
    <div style={{ backgroundColor: "#ffe4c4", minHeight: "100vh", padding: "20px" }}>
      <Link
        to="/addnote"
        style={{
          display: "block",
          marginBottom: "20px",
          textDecoration: "none",
          backgroundColor: "#007bff",
          color: "#fff",
          padding: "10px 20px",
          borderRadius: "5px",
        }}
      >
         Add New Task
      </Link>

      <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "20px" }}>
        <tbody>
          <tr>
            <th
              style={{
                backgroundColor: "#f2f2f2",
                padding: "10px",
                textAlign: "left",
              }}
            >
              Title
            </th>
            <th style={{ padding: "10px", border: "1px solid #ccc" }}>Description</th>
            <th style={{ padding: "10px", border: "1px solid #ccc" }}>Actions</th>
          </tr>
          {notes.map((note) => (
            <tr key={note.id}>
              <td style={{ padding: "10px", border: "1px solid #ccc" }}>{note.title}</td>
              <td style={{ padding: "10px", border: "1px solid #ccc" }}>{note.body}</td>
              <td style={{ padding: "10px", border: "1px solid #ccc" }}>
                <Link to={`/view/${note.id}`} style={{ textDecoration: "none", color: "#007bff" }}>
                  View Task
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Notes;
