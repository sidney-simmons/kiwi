// Custom options (some of the properties here can be a duplicate of what's in "@/properties/Properties" - please keep them in sync!
let customObject = {
    "full-name": "Sidney Simmons",
    "google-analytics-id": "UA-110674077-3",
};

// Vue configuration
module.exports = {
    pages: {
        "software-engineer": {
            entry: "src/pages/software-engineer/software-engineer.js",
            template: "public/pages/index.html",
            filename: "templates/software-engineer.html",
            title: "Sidney Simmons - Software Engineer",
            chunks: ["chunk-vendors", "chunk-common", "software-engineer"],
            description: "Personal portfolio of software related projects. Technologies include java, spring, gradle, docker, kubernetes, etc.",
            keywords: "sidney,simmons,portfolio,software,engineer,java,spring,gradle,docker,kubernetes",
            customObject: customObject,
        },
        contact: {
            entry: "src/pages/contact/contact.js",
            template: "public/pages/index.html",
            filename: "templates/contact.html",
            title: "Sidney Simmons - Contact",
            chunks: ["chunk-vendors", "chunk-common", "contact"],
            description: "Contact Sidney through email!",
            keywords: "sidney,simmons,contact,email",
            customObject: customObject,
        },
    },
    configureWebpack: {
        performance: {
            hints: false,
        },
    },
};
