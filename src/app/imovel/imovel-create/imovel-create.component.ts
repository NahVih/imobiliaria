import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ImovelService } from '../imovel.service';
import { Imovel } from '../imovel.model';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';



@Component({
  selector: 'app-imovel-create',
  templateUrl: './imovel-create.component.html',
  styleUrls: ['./imovel-create.component.css']
})
export class ImovelCreateComponent implements OnInit {

  categoriaImoveis: any = ['APARTAMENTO', 'CASA', 'COMERCIAL', 'TERRENO']
  tipoProposta: any = ['VENDA', 'LOCACAO', 'VENDALOCACAO', 'PERMUTA']
  
  imovelForm = new FormGroup({
    categoriaImovel: new FormControl(''),
    tipoProposta: new FormControl(''),
    valorImovel: new FormControl(''),
    endereco: new FormControl(''),
    bairro: new FormControl(''),
    condominio: new FormControl(''),
    descricao: new FormControl(''),
  });


  imovel: Imovel;
  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  constructor(private service: ImovelService) { }

  ngOnInit(): void {     
  }

  
  public onFileChanged(event) {
    //Select File
    this.selectedFile = event.target.files[0];
  }

  onSubmit(){
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const param = new FormData();
    param.append('file', this.selectedFile, this.selectedFile.name);
    

    //Make a call to the Spring Boot Application to save the image
    this.imovel = this.imovelForm.value
    this.service.criarImovel(this.imovel, param).subscribe(response => {
      
      if(response.status === 200) {
        let id = response.body.id
        alert('Imovel criado com sucesso ID: -- > ' + id)
      }

    })
  }

   

}
