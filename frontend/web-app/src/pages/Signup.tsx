import React, { useState } from "react";
import { motion } from "framer-motion";

type Role = "college" | "vendor" | "user";

const Signup: React.FC = () => {
  const [role, setRole] = useState<Role>("user");

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Submit:", role);
  };

  return (
    <div className="min-h-screen flex items-center justify-center bg-[#0B0F1A] px-4">

      {/* 🌌 Glow Background */}
      <div className="absolute w-[500px] h-[500px] bg-indigo-500/20 blur-3xl rounded-full top-10 left-10"></div>
      <div className="absolute w-[400px] h-[400px] bg-purple-500/20 blur-3xl rounded-full bottom-10 right-10"></div>

      {/* 🧊 FORM CARD */}
      <div className="relative w-full max-w-2xl p-8 rounded-2xl
        bg-white/5 backdrop-blur-xl border border-white/10 shadow-2xl">

        {/* 🔥 TITLE */}
        <h1 className="text-3xl font-bold text-center mb-2">
          <span className="bg-gradient-to-r from-indigo-400 via-purple-400 to-pink-400 bg-clip-text text-transparent">
            Create Account
          </span>
        </h1>

        <p className="text-gray-400 text-center mb-6 text-sm">
          Join CampusHub ecosystem
        </p>

        {/* 🔘 ROLE SWITCH */}
        <div className="flex mb-6 bg-white/5 p-1 rounded-xl">
          {["user", "vendor", "college"].map((r) => (
            <button
              key={r}
              type="button"
              onClick={() => setRole(r as Role)}
              className={`w-full py-2 text-sm rounded-lg transition ${
                role === r
                  ? "bg-gradient-to-r from-indigo-500 to-purple-500 text-white"
                  : "text-gray-400 hover:text-white"
              }`}
            >
              {r.toUpperCase()}
            </button>
          ))}
        </div>

        {/* 🧠 FORM */}
        <form onSubmit={handleSubmit} className="space-y-4">

          {/* ================= USER ================= */}
          {role === "user" && (
            <>
              <input className="input" placeholder="Full Name" />
              <select className="input">
                <option>Student</option>
                <option>Faculty</option>
              </select>
              <input className="input" placeholder="Email" />
              <input className="input" placeholder="Password" />
              <input className="input" placeholder="Confirm Password" />
              <input className="input" placeholder="Search College" />
            </>
          )}

          {/* ================= VENDOR ================= */}
          {role === "vendor" && (
            <>
              <input className="input" placeholder="Owner Name" />
              <input className="input" placeholder="Shop Name" />
              <input className="input" placeholder="Email" />
              <input className="input" placeholder="Phone" />
              <input className="input" placeholder="Password" />
              <input className="input" placeholder="Confirm Password" />

              <input type="file" className="input" />
            </>
          )}

          {/* ================= COLLEGE ================= */}
          {role === "college" && (
            <>
              <input className="input" placeholder="College Name" />
              <input className="input" placeholder="Domain" />
              <input className="input" placeholder="Official Email" />
              <input className="input" placeholder="Phone" />

              <input className="input" placeholder="Country" />
              <input className="input" placeholder="State" />
              <input className="input" placeholder="City" />

              <input className="input" placeholder="Password" />
              <input className="input" placeholder="Confirm Password" />
            </>
          )}

          {/* 🔘 SUBMIT */}
          <motion.button
            whileHover={{ scale: 1.03 }}
            whileTap={{ scale: 0.97 }}
            type="submit"
            className="w-full mt-4 py-3 rounded-xl font-semibold text-white
            bg-gradient-to-r from-indigo-500 to-purple-500
            shadow-lg hover:shadow-xl transition"
          >
            Create {role} Account
          </motion.button>

        </form>
      </div>
    </div>
  );
};

export default Signup;