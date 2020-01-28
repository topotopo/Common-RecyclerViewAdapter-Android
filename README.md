# Generic Adapter

This is a sample app using a generic adapter. GenericAdapter is is an extension of Recyclerview adapter that is designed to hold and bind different data models for different viewtypes without creating different binding logics for each view by following a specific convention.

## How to use

### Creating the item layout
When creating the item xml layouts, declare the data to bind with the variable name as "data."

### Creating GenericItemViewHolders
For each type of view, you will create a GenericItemViewHolder. GenericItemViewHolder should holds the view's corresponding data model and layout id to bind.

### Use GenericAdapter as you use a RecyclerView adapter
Use GenericAdadpter as the adapter in the RecyclerView list. GenericAdapter will only accept a list of GenericItemViewHolders.

## How does it work?
<To Do>

## Authors
Maxine Micu - Initial Work
