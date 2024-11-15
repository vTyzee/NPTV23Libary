package ee.ivkhkdev;


import ee.ivkhkdev.apphelpers.CardAppHelper;
import ee.ivkhkdev.apphelpers.UserAppHelper;
import ee.ivkhkdev.factory.Factory;
import ee.ivkhkdev.factory.JavaConfiguration;
import ee.ivkhkdev.interfaces.AppHelper;
import ee.ivkhkdev.apphelpers.AuthorAppHelper;
import ee.ivkhkdev.apphelpers.BookAppHelper;
import ee.ivkhkdev.interfaces.FileRepository;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Card;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.services.AuthorService;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.interfaces.Service;
import ee.ivkhkdev.services.CardService;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storage.Storage;


public class NPTV23Library {

    public static void main(String[] args) {
        Factory factory = Factory.getInstance(new JavaConfiguration());

        AppHelper<Author> authorAppHelper = (AppHelper<Author>) factory.getObject("authorAppHelper");
        AppHelper<User> userAppHelper = (AppHelper<User>) factory.getObject("userAppHelper");
        FileRepository<Author> authorStorage = (FileRepository<Author>) factory.getObject("authorStorage");
        FileRepository<Book> bookStorage = (FileRepository<Book>) factory.getObject("bookStorage");
        FileRepository<User> userStorage = (FileRepository<User>) factory.getObject("userStorage");
        FileRepository<Card> cardStorage = (FileRepository<Card>) factory.getObject("cardStorage");
        Service<User> userService = (Service<User>) factory.getObject("userService");
        Service<Author> authorService = (Service<Author>) factory.getObject("authorService");
        AppHelper<Book> bookAppHelper = (AppHelper<Book>) factory.getObject("bookAppHelper");
        Service<Book> bookService = (Service<Book>) factory.getObject("bookService");
        AppHelper<Card> cardAppHelper = (AppHelper<Card>) factory.getObject("cardAppHelper");
        Service<Card> cardService = (Service<Card>) factory.getObject("cardService");

        ((App) factory.getObject("app")).run();
    }
}
