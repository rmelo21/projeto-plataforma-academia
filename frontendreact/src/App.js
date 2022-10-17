import React from "react";
import LoginPage from "./pages/LoginPage";
import HeaderMenu from "./pages/HeaderMenu";
import StudentRegister from "./pages/StudentRegister";
import WorkerRegister from "./pages/WorkerRegister";

// class App extends React.Component {
//   render() {
//     return (

//     );
//   }
// }

export default function App(props) {
  return (
    <div>
      <LoginPage />
      <HeaderMenu />
      <StudentRegister />
      <WorkerRegister />
    </div>
  );
};