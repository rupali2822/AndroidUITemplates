package com.example.androiduitemplates.adapter;

public interface OnMoveAndSwipeListener {
boolean onItemMove(int fromPosition,int toPosition);
void onItemDismiss(int position);
}
