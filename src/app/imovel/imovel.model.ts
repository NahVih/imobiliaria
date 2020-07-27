enum CategoriaImovel {
    APARTAMENTO,
	CASA,
	COMERCIAL,
	TERRENO
}

enum TipoProposta {
    VENDA,
	LOCACAO,
	VENDALOCACAO,
	PERMUTA
}

export class Imovel {
    categoriaImovel: CategoriaImovel;
    tipoProposta: TipoProposta
    valorImovel: number;
    endereco: string;
    bairro: string;
    condominio: string;
    descricao: string;
}
