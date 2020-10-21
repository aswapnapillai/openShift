import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { BOOK } from '../book';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { FavoriteService } from '../favorite.service';
import { BookRecommendationService } from '../bookRecommendation.service';

@Component({
  selector: 'app-bookRecommendation-detail',
  templateUrl: './book-recommendation.component.html',
  styleUrls: ['./book-recommendation.component.scss']
})
export class BookRecommendationComponent implements OnInit {
  private bookReclist: BOOK[]=[];
  constructor(private router: Router,
              private bookRecommendationService: BookRecommendationService,
              private bookService: BookService,
              private userService: UserService) { }
  private user: string = this.userService.userId;
  ngOnInit() {
    if (!localStorage.getItem("accessToken")) {
      this.router.navigate(["login"]);
    }
    this.bookRecommendationService.getAllRec().subscribe(data => {
      this.bookReclist = data;
    })
  }
  booKTag(item) {
    this.bookService.setCurrentBook(item);
    this.router.navigate(["bookDetail"]);
  }
  clickBack() {
    this.router.navigate(["dashboard"]);
  }
  logOut() {
    this.bookService.deleteBooklist();
    localStorage.removeItem("accessToken");
    this.router.navigate(["login"]);
  }

}
