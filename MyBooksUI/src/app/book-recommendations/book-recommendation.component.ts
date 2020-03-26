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

  constructor(private bookService: BookRecommendationService,
    private router: Router,
    private userService: UserService,
    private favoriteService: FavoriteService) { }
  private bookRecommendation: BOOK[]=[];
  user: string = this.userService.userId;
  favorite: boolean = false;
  ngOnInit() {
    if (!localStorage.getItem("accessToken")) {
      this.router.navigate(["login"]);
    }
    this.favoriteService.getAllFavorite().subscribe(data => {
      this.bookRecommendation = data;
    })
  }
  clickBack() {
    this.router.navigate(["dashboard"]);
  }
  logOut() {
    localStorage.removeItem("accessToken");
    this.router.navigate(["login"]);
  }



}
