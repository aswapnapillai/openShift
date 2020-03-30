import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";
import { BOOK } from "./book";

@Injectable({
  providedIn: "root"
})
export class BookRecommendationService {
  private getAllUserRec: string = "http://localhost:9876/getRec";

  constructor(private http: HttpClient) {}

  httpOptions(): object {
    return {
      headers: {
        Authorization: "Bearer " + localStorage.getItem("accessToken")
      }
    };
  }

  getAllRec(): Observable<any> {
    return this.http.get<any>(this.getAllUserRec, this.httpOptions());
  }
}
