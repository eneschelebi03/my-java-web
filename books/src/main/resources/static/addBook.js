// Adding a book
let addBookBtn = document.getElementById('addBook')

addBookBtn.addEventListener('click', addBook);

function addBook(){
    var titleVar = $('#title').val();
    var authorVar = {
        'name': $('#author').val()
    };
    var isbnVar = $('#isbn').val();
    var newBook = {
        "title": titleVar,
        "author": authorVar,
        "isbn": isbnVar
    };
    $.ajax({
        'url' : 'http://localhost:8080/api/books/addBook',
        'type' : 'POST',
        'contentType' : 'application/json',
        'dataType': 'json',
        'data' : JSON.stringify(newBook),
        'success' : function() {
           location.href = "http://localhost:8080";
        }
    })
        .catch(error => console.log('error', error));
}