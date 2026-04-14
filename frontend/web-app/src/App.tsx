import { Routes, Route, useLocation } from "react-router-dom";
import Header from "./components/layout/Header";
import Footer from "./components/layout/Footer";
import Login from "./pages/Login";
import Signup from "./pages/Signup";

function App() {
  const location = useLocation();

  const hideLayout = location.pathname === "/login";

  return (
    <div className="min-h-screen flex flex-col bg-[#0B0F1A] text-white">

      {/* 🔥 Header hidden on login */}
      {!hideLayout && <Header />}

      {/* 🧠 Dynamic Body */}
      <main className="flex-1 p-6">
        <Routes>
          {/* Default route (IMPORTANT) */}
          <Route path="/" element={<div>Home Page</div>} />

          {/* Login route */}
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
        </Routes>
      </main>

      {/* 🔥 Footer hidden on login */}
      {!hideLayout && <Footer />}

    </div>
  );
}

export default App;