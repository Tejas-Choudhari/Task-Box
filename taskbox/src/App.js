import './App.css';
import Notes from './components/notes';
import{BrowserRouter,Routes,Route,Navigate} from 'react-router-dom';
import AddNoteComponent from './components/AddNoteComponent';
import NoteViewComponent from './components/NotesViewComponent';


function App() {
  return (
    <div >
      <BrowserRouter>
      <Routes>
        <Route path='/mynote' element={<Notes />}></Route>
        <Route path='/addnote' element={<AddNoteComponent />}></Route>
        <Route path='/view/:id' element={<NoteViewComponent />}></Route>
        <Route path='/editnote/:id' element={<AddNoteComponent />}></Route>
        <Route path='/' element={<Notes/>}></Route>

      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
