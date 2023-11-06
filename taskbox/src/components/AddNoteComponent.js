import { Formik, Field, Form } from "formik";
import { Editor } from "@tinymce/tinymce-react";
import * as applicationConstant from "../util/ApplicationConstant";
import { readOne, saveNotes, updateOne } from "../services/notes.service";
import { Link, useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";

const AddNoteComponent = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [title, setTitle] = useState('');
  const [body, setBody] = useState('');
  const [updatedAt, setUpdatedAt] = useState('');
  const [autoIncrementId, setAutoIncrementId] = useState(null);

  const handleSubmit = async (values) => {
    let response = null;

    if (values.id) {
      response = await updateOne(values);
    } else {
      response = await saveNotes(values);
    }

    if (!response) {
      throw Error('Error occurred while storing the data');
    }
    console.log(`Printing the response ${response.data}`);

    navigate("/");
  }

  const getNoteById = async () => {
    try {
      const response = await readOne(id);
      const existingNote = response.data;

      setTitle(existingNote.title);
      setBody(existingNote.body);
      setUpdatedAt(existingNote.updatedAt);
      setAutoIncrementId(existingNote.setAutoIncrementId);
    } catch (error) {
      console.error('Error occurred while retrieving the data from API');
    }
  }

  useEffect(() => {
    if (id) {
      getNoteById(id);
    }
  }, [id]);

  return (
    <div style={{ backgroundColor: "#ffe4c4", minHeight: "100vh" }}>
      <h1 style={{ textAlign: "center" }}>Add New Task</h1>
      <Formik
        initialValues={{
          id: autoIncrementId,
          title: title,
          body: body
        }}
        enableReinitialize
        onSubmit={handleSubmit}
      >
        <Form>
          <Field id="id" name="id" type="hidden"></Field>
          <label>Title</label>
          <Field
            placeholder="Enter Title"
            name="title"
            style={{ width: "100%", padding: "10px" }}
          />
          <label>Description</label>
          <Field
            placeholder="Enter Description"
            name="body"
            style={{ width: "100%", padding: "10px" }}
          >
            {({ form }) => {
              const { setFieldValue } = form;
              return (
                <>
                  <Editor
                    apiKey={applicationConstant.TINYMCE_API_KEY}
                    value={form.values.body}
                    init={{
                      height: 500,
                      menubar: true,
                      plugins: 'ai tinycomments mentions anchor autolink charmap codesample emoticons image link lists media searchreplace table visualblocks wordcount checklist mediaembed casechange export formatpainter pageembed permanentpen footnotes advtemplate advtable advcode editimage tableofcontents mergetags powerpaste tinymcespellchecker autocorrect a11ychecker typography inlinecss',
                      toolbar: 'undo redo | blocks fontfamily fontsize | bold italic underline strikethrough | link image media table mergetags | align lineheight | tinycomments | checklist numlist bullist indent outdent | emoticons charmap | removeformat',
                      tinycomments_mode: 'embedded',
                      tinycomments_author: 'Author name',
                      mergetags_list: [
                        { value: 'First.Name', title: 'First Name' },
                        { value: 'Email', title: 'Email' },
                      ],
                      ai_request: (request, respondWith) => respondWith.string(() => Promise.reject("See docs to implement AI Assistant")),
                    }}
                    onEditorChange={(content) => {
                      setFieldValue('body', content)
                    }}
                  />
                </>
              )
            }}
          </Field>
          <button
            type="submit"
            style={{
              display: "block",
              margin: "10px auto",
              padding: "10px 20px",
              backgroundColor: "#007bff", // Set your desired button color
              color: "#fff", // Text color
              border: "none",
              borderRadius: "5px",
              cursor: "pointer",
            }}
          >
            Submit
          </button>
        </Form>
      </Formik>
      <Link to="/mynote" style={{ display: "block", textAlign: "center", textDecoration: "none", color: "#007bff" }}>Back To Tasks</Link>
    </div>
  );
}

export default AddNoteComponent;
