const fs = require('fs');
const readline = require('readline');

const FILE = 'books.json';

function loadBooks() {
    try {
        const data = fs.readFileSync(FILE, 'utf8');
        return JSON.parse(data);
    } catch (err) {
        return [];
    }
}

function saveBooks(books) {
    fs.writeFileSync(FILE, JSON.stringify(books, null, 2));
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function showMenu() {
    console.log(`
1. Add a new book
2. List all books
3. Search books by title
4. Remove a book by title
5. Exit
`);
    rl.question('Choose an option: ', handleMenu);
}

function handleMenu(option) {
    switch(option.trim()) {
        case '1':
            addBook();
            break;
        case '2':
            listBooks();
            break;
        case '3':
            searchBook();
            break;
        case '4':
            removeBook();
            break;
        case '5':
            console.log('Goodbye!');
            rl.close();
            break;
        default:
            console.log('Invalid option. Try again.');
            showMenu();
    }
}

function addBook() {
    const book = {};
    rl.question('Title: ', title => {
        book.title = title;
        rl.question('Author: ', author => {
            book.author = author;
            rl.question('Year of publication: ', year => {
                book.year = year;
                rl.question('Genre: ', genre => {
                    book.genre = genre;
                    const books = loadBooks();
                    books.push(book);
                    saveBooks(books);
                    console.log('Book added successfully!\n');
                    showMenu();
                });
            });
        });
    });
}

function listBooks() {
    const books = loadBooks();
    if (books.length === 0) {
        console.log('No books found.\n');
    } else {
        books.forEach((b, i) => {
            console.log(`${i + 1}. ${b.title} | ${b.author} | ${b.year} | ${b.genre}`);
        });
        console.log('');
    }
    showMenu();
}

function searchBook() {
    rl.question('Enter title to search: ', term => {
        const books = loadBooks();
        const results = books.filter(b => b.title.toLowerCase().includes(term.toLowerCase()));
        if (results.length === 0) {
            console.log('No books found.\n');
        } else {
            results.forEach((b, i) => {
                console.log(`${i + 1}. ${b.title} | ${b.author} | ${b.year} | ${b.genre}`);
            });
            console.log('');
        }
        showMenu();
    });
}

function removeBook() {
    rl.question('Enter title to remove: ', title => {
        let books = loadBooks();
        const initialLength = books.length;
        books = books.filter(b => b.title.toLowerCase() !== title.toLowerCase());
        if (books.length === initialLength) {
            console.log('Book not found.\n');
        } else {
            saveBooks(books);
            console.log('Book removed successfully!\n');
        }
        showMenu();
    });
}


showMenu();