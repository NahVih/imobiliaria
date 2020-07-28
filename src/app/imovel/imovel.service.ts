import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Imovel } from './imovel.model';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, map } from 'rxjs/operators';
import { error } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class ImovelService {

  constructor(private http : HttpClient) { }

createImovel(imovel: Imovel, param: FormData){

  let tokenStri = 'Bearer '+localStorage.getItem('token');
  const headerReq = new HttpHeaders().set('Authorization',tokenStri);

   let { categoriaImovel, tipoProposta, endereco, bairro, condominio, descricao, valorImovel } = this.extraiImovel(imovel);
    const url = `http://localhost:8080/imovel/criarImovelComFotos/${categoriaImovel}/${tipoProposta}/${endereco}/${bairro}/${condominio}/${descricao}/${valorImovel}`

  return this.http.post(url, param, {observe: 'response'}).subscribe((response) => {
      if (response.status === 200) {
       return  console.log('Image uploaded successfully')
      } else {
       return  console.log('Image not uploaded successfully');
      }});
}


 criarImovel(imovel: Imovel, param: FormData): Observable<any>{
  
  let { categoriaImovel, tipoProposta, endereco, bairro, condominio, descricao, valorImovel } = this.extraiImovel(imovel);
  const url = `http://localhost:8080/imovel/criarImovelComFotos/${categoriaImovel}/${tipoProposta}/${endereco}/${bairro}/${condominio}/${descricao}/${valorImovel}`

  let tokenStri = 'Bearer '+localStorage.getItem('token');
  const headerReq = new HttpHeaders().set('Authorization',tokenStri);

  return this.http.post(url, param, {headers: headerReq , observe: 'response'})
  .pipe(
    map((response: any) => {
      return response
    }), 
    catchError(this.handleError)
  );
 }

 

  private extraiImovel(imovel: Imovel) {
    let endereco = imovel.endereco;
    let bairro = imovel.bairro;
    let categoriaImovel = imovel.categoriaImovel;
    let descricao = imovel.descricao;
    let valorImovel = imovel.valorImovel;
    let condominio = imovel.condominio;
    let tipoProposta = imovel.tipoProposta;
    return { categoriaImovel, tipoProposta, endereco, bairro, condominio, descricao, valorImovel };
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
 
}
  


