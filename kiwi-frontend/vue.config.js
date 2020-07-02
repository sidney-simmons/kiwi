module.exports = {
    pages : {
        'software-engineer' : {
            entry : 'src/pages/software-engineer/software-engineer.js',
            template : 'public/pages/software-engineer.html',
            filename : 'templates/software-engineer.html',
            title : 'Sidney Simmons - Software Engineer',
            chunks : [ 'chunk-vendors', 'chunk-common', 'software-engineer' ]
        },
        'contact' : {
            entry : 'src/pages/contact/contact.js',
            template : 'public/pages/contact.html',
            filename : 'templates/contact.html',
            title : 'Sidney Simmons - Contact',
            chunks : [ 'chunk-vendors', 'chunk-common', 'contact' ]
        }
    }
}