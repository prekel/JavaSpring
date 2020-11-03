import React, { useEffect, useState } from "react";
import { Card, Table, Jumbotron, Row } from "react-bootstrap";

import { MyComponent } from "./MyComponent";

export const Furnitures: React.FunctionComponent = () => {
  return (
    <>
      <Jumbotron>
        <h3>furnitures</h3>
      </Jumbotron>
        <Card className="mb-4">
          <Card.Body>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>#</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Username</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Mark</td>
                  <td>Otto</td>
                  <td>@mdo</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Jacob</td>
                  <td>Thornton</td>
                  <td>@fat</td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Larry the Bird</td>
                  <td>@twitter</td>
                  <td>@twitter</td>
                </tr>
              </tbody>
            </Table>
          </Card.Body>
        </Card>
        <Card className="mb-4">
          <Card.Body>
            <MyComponent></MyComponent>
          </Card.Body>
        </Card>
    </>
  );
};
