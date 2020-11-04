import React from "react";
import { Switch, Route, useParams } from "react-router";

import { Furnitures } from "./Furnitures";
import { AddFurniture } from "./AddFurniture";
import { UpdateFurniture } from "./UpdateFurniture";
import { DeleteFurniture } from "./DeleteFurniture";
import { FurnituresByType } from "./FurnituresByType";
import { Home } from "./Home";

export const MainSwitch: React.FunctionComponent = () => {
  return (
    <>
      <Switch>
        <Route path="/furnitures">
          <Furnitures />
        </Route>
        <Route path="/furnitures-by-type">
          <FurnituresByType />
        </Route>
        <Route path="/update">
          <UpdateFurniture />
        </Route>
        <Route path="/delete">
          <DeleteFurniture />
        </Route>
        <Route path="/add">
          <AddFurniture />
        </Route>
        <Route path="/:par">
          <Dgf />
        </Route>
        <Route path="/">
          <Home />
        </Route>
      </Switch>
    </>
  );
};

const Dgf: React.FunctionComponent = () => {
  let { par } = useParams<{ par: string }>();
  return <p>{par}</p>;
};
