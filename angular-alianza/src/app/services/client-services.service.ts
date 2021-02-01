import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientModel } from '../models/client.model';

@Injectable({
  providedIn: 'root'
})
export class ClientServicesService {

  constructor(private http: HttpClient) { }

  private readonly urlHeader = 'http://localhost:8080';

  /**
   * Service to get clients list
   * @returns Observable<ClientModel[]>
   * @author grangel
   */
  public getClientsList(): Observable<ClientModel[]> {
    return this.http.get<ClientModel[]>(this.urlHeader + '/client/list-clients');
  }

  /**
   * Service to get a client information
   * @param search string
   * @returns Observable<ClientModel[]>
   * @author grangel
   */
  public getClientInfo(search: string): Observable<ClientModel[]> {
    return this.http.get<ClientModel[]>(this.urlHeader + '/client/info-client', {
      params: {
        search
      }
    });
  }

  /**
   * Service to create a client
   * @param client ClientModel
   * @author grangel
   */
  public createClient(client: ClientModel): Observable<boolean> {
    return this.http.post<boolean>(this.urlHeader + '/client/create-client', client);
  }
}
