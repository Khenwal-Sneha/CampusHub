import React from "react";

const Footer: React.FC = () => {
  return (
    <footer className="mt-10 px-6 py-6 
      bg-white/5 backdrop-blur-xl border-t border-white/10">

      <div className="max-w-7xl mx-auto flex flex-col md:flex-row 
        items-center justify-between gap-4 text-gray-400 text-sm">

        {/* 🧠 Brand */}
        <div className="flex items-center gap-2">
          <span className="text-white font-semibold">CampusHub</span>
          <span>© {new Date().getFullYear()}</span>
        </div>

        {/* 🔗 Links */}
        <div className="flex gap-6">
          <span className="hover:text-white cursor-pointer transition">
            Privacy Policy
          </span>
          <span className="hover:text-white cursor-pointer transition">
            Terms
          </span>
          <span className="hover:text-white cursor-pointer transition">
            Contact
          </span>
        </div>
      </div>
    </footer>
  );
};

export default Footer;